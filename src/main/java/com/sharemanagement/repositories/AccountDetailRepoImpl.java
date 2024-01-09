package com.sharemanagement.repositories;

import com.sharemanagement.entities.AccountDetail;
import com.sharemanagement.entities.FamilyMember;
import org.apache.juli.logging.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
        query.where(builder.equal(root.get("familyId"), familyId));

        Query<AccountDetail> q = session.createQuery(query);
        return q.getResultList();
    }

}
