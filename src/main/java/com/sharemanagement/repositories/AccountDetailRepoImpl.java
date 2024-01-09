package com.sharemanagement.repositories;

import com.sharemanagement.entities.AccountDetail;
import com.sharemanagement.entities.FamilyMember;
import org.apache.juli.logging.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.util.List;


@Repository
public class AccountDetailRepoImpl implements AccountDetailRepo{

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void saveAccountDetail(List<AccountDetail> accountDetails) {
        Session session = sessionFactory.getCurrentSession();

        for (AccountDetail accountDetail : accountDetails) {
                session.merge(accountDetail);
        }

       // accountDetails.forEach(accountDetail -> session.saveOrUpdate(accountDetail));
       // session.persist(accountDetails);

    }

    @Override
    public List<AccountDetail> getAllAccountDetails(int familyId) {

        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<AccountDetail> query = builder.createQuery(AccountDetail.class);
        Root<AccountDetail> root = query.from(AccountDetail.class);

        query.select(root);
        query.where(
                builder.and(
                        builder.equal(root.get("familyId"), familyId),
                        builder.equal(root.get("status"), 1)
                )
        );

        Query<AccountDetail> q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public void deleteAccountdetails(int accDetId) {

        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaUpdate<AccountDetail> update = builder.createCriteriaUpdate(AccountDetail.class);
        Root<AccountDetail> root = update.from(AccountDetail.class);

        update.set("status", 0);
        update.where(builder.equal(root.get("accDetId"), accDetId));

        session.createQuery(update).executeUpdate();
    }

}
