package com.laurens.kanbanboard.utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;


//JPAConnectionManager as Singleton
public class JPAConnectionManager {

	private static JPAConnectionManager jpaConnectionManager = null;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private JPAQueryFactory jpaQueryFactory;
	

	private JPAConnectionManager(String persistenceUnit) {
		this.entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
		this.entityManager = entityManagerFactory.createEntityManager();
		this.jpaQueryFactory = new JPAQueryFactory(this.entityManager);
	}

	public static JPAConnectionManager getJPAConnectionManager(String persistenceUnit) {
		if (jpaConnectionManager == null) {
			jpaConnectionManager = new JPAConnectionManager(persistenceUnit);
		}
		return jpaConnectionManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public JPAQueryFactory getJPAQueryFactory() {
		return jpaQueryFactory;
	}
	
	public void closeEntityManagerFactory() {
		entityManager.close();
		entityManagerFactory.close();
	}

}
