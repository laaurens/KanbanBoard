package com.laurens.kanbanboard.utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


//JPAConnectionManager as Singleton
public class JPAConnectionManager {

	private static JPAConnectionManager jpaConnectionManager = null;
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	

	private JPAConnectionManager(String persistenceUnit) {
		this.entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);
		this.entityManager = entityManagerFactory.createEntityManager();
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

}
