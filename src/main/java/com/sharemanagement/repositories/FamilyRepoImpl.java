package com.sharemanagement.repositories;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

	@Override
	public List<FamilyMember> getAllFamily(int pageCount) {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<FamilyMember> query = builder.createQuery(FamilyMember.class);
		Root<FamilyMember> root = query.from(FamilyMember.class);
		
		query.select(root);
		
		Predicate where;
		where = builder.equal(root.get("status"), 1);
		query.where(where);
		
		Query<FamilyMember> q = session.createQuery(query);
		return q.setFirstResult(pageCount).setMaxResults(10).getResultList();
	}

	@Override
	public long getFamilyTotalCount() {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		Root<FamilyMember> root = query.from(FamilyMember.class);
		query.multiselect(builder.count(root));
		
		Predicate where;
		where = builder.equal(root.get("status"),1);
		query.where(where);
		
		Query<Long> q = session.createQuery(query);
		
		return q.getSingleResult();
		
	}

	@Override
	public FamilyMember getFamilyMemberById(Long memberId) {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<FamilyMember> query = builder.createQuery(FamilyMember.class);
		Root<FamilyMember> root = query.from(FamilyMember.class);
		
		query.select(root);
		
		Predicate where;
		where = builder.equal(root.get("memberId"), memberId);
		query.where(where);
	    Query<FamilyMember> q =session.createQuery(query);
		return q.getSingleResult();
	}

	@Override
	public void deleteMemberFromFamily(FamilyMember familyMember) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(familyMember);
		
	}

	@Override
	public FamilyMember getFamilyMemberByIdActive(Long memberId) {
	    
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<FamilyMember> query = builder.createQuery(FamilyMember.class);
		Root<FamilyMember> root = query.from(FamilyMember.class);
		
		query.select(root);
		
		Predicate where;
		where = builder.equal(root.get("memberId"), memberId);
		where = builder.and(where,builder.equal(root.get("status"),1));
		query.where(where);
	    Query<FamilyMember> q =session.createQuery(query);
	    try {
	    	
		   return q.getSingleResult();
		   
	    }catch(Exception e) {
	    	return null;
	    }
	}

	@Override
	public List<FamilyMember> getFamilyById(BigInteger familyId) {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<FamilyMember> query = builder.createQuery(FamilyMember.class);
		Root<FamilyMember> root = query.from(FamilyMember.class);
		
		query.select(root);
		
		Predicate where;
		where = builder.equal(root.get("familyId"), familyId);
		where = builder.and(where,builder.equal(root.get("status"), 1));
		query.where(where);
		
		Query<FamilyMember> q = session.createQuery(query);
		
		try {
			
		 return q.getResultList();
		 
		}catch(Exception e) {
			
			return null;
		}
	}

	@Override
	public void deleteFamilyById(Family family) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(family);
		
	}

	@Override
	public Family getMainFamily(long familyId) {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Family> query = builder.createQuery(Family.class);
		Root<Family> root = query.from(Family.class);
		
		query.select(root);
		
		Predicate where;
		where = builder.equal(root.get("familyId"),familyId);
		where = builder.and(where,builder.equal(root.get("status"),1));
		query.where(where);
		
		Query<Family> q = session.createQuery(query);
		try {
		return q.getSingleResult();
		}catch(Exception e) {
			return new Family();
		}
	}

}
