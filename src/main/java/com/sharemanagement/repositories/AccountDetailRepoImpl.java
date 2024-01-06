package com.sharemanagement.repositories;

import com.sharemanagement.entities.AccountDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class AccountDetailRepoImpl implements AccountDetailRepo{

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public void saveAccountDetail(AccountDetail accountDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.save(accountDetail);

    }
}
