package com.sharemanagement.repositories;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharemanagement.entities.Family;
import com.sharemanagement.entities.FamilyMember;

@Repository
public class FamilyRepoImpl implements FamilyRepo {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Long createFamily(FamilyMember obj) {
		
		Session session = sessionFactory.getCurrentSession();
		Serializable id = session.save(obj);
		return (Long) id;
	}

	@Override
	public Long createFamilyId(Family family) {
		
		Session session = sessionFactory.getCurrentSession();
		Serializable id = session.save(family);
		return (Long) id;
	}

}
