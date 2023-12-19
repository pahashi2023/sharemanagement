package com.sharemanagement.repositories;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImpl implements UserRepo {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public User findUserByEmail(String email) {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<com.sharemanagement.entities.User> query = builder.createQuery(com.sharemanagement.entities.User.class);
		Root<com.sharemanagement.entities.User> root = query.from(com.sharemanagement.entities.User.class);
		
		query.select(root);
		
		Predicate where;
		
		where = builder.equal(root.get("emailId"), email);
		
		query.where(where);
		
		Query<com.sharemanagement.entities.User> q = session.createQuery(query);
		
		com.sharemanagement.entities.User result = q.getSingleResult();
		
		User det  = new User(result.getEmailId(), result.getPassword(), new ArrayList<>());
		return det;
	}

	@Override
	public com.sharemanagement.entities.User getUserIdByEmail(String email) {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<com.sharemanagement.entities.User> query = builder.createQuery(com.sharemanagement.entities.User.class);
		Root<com.sharemanagement.entities.User> root = query.from(com.sharemanagement.entities.User.class);
		
		query.select(root);
		
		Predicate where;
		
		where = builder.equal(root.get("emailId"), email);
		
		query.where(where);
		
		Query<com.sharemanagement.entities.User> q = session.createQuery(query);
		
		com.sharemanagement.entities.User result = q.getSingleResult();
		
		return result;
	}

}
