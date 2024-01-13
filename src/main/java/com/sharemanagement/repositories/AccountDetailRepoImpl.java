package com.sharemanagement.repositories;

import com.sharemanagement.entities.AccountDetail;
import com.sharemanagement.entities.AccountMemberDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Date;

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
            try {
                // Save or update AccountDetail
                session.saveOrUpdate(accountDetail);

                long accDetId = accountDetail.getAccDetId();

                List<AccountMemberDetails> memberDetails = accountDetail.getAccountMemberDetails();
                if (memberDetails != null) {
                    for (AccountMemberDetails memberDetail : memberDetails) {

                        memberDetail.setAccDetId(accDetId);
                        session.saveOrUpdate(memberDetail);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error saving/updating AccountDetail: {} " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    @Override
    public List<AccountDetail> getAllAccountDetails(int familyId,String accountType) {

        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<AccountDetail> query = builder.createQuery(AccountDetail.class);

        Root<AccountDetail> accountDetailRoot = query.from(AccountDetail.class);
        accountDetailRoot.fetch("accountMemberDetails", JoinType.LEFT);

        query.select(accountDetailRoot);
        query.where(
                builder.equal(accountDetailRoot.get("familyId"), familyId),
                builder.equal(accountDetailRoot.get("status"), 1),
                builder.equal(accountDetailRoot.get("accountType"), accountType)
        );

        Query<AccountDetail> typedQuery = session.createQuery(query);
        return typedQuery.getResultList();
    }

    @Override
    public void deleteAccountdetails(int accDetId) {

        Session session = sessionFactory.getCurrentSession();
        LocalDateTime currentDateTime = LocalDateTime.now();

        Date updatedDate = java.sql.Timestamp.valueOf(currentDateTime);
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaUpdate<AccountDetail> update = builder.createCriteriaUpdate(AccountDetail.class);
        Root<AccountDetail> root = update.from(AccountDetail.class);

        update.set("status", 0);
        update.set("updatedDate",updatedDate);
        update.where(builder.equal(root.get("accDetId"), accDetId));

        session.createQuery(update).executeUpdate();
    }

}
