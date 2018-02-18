package com.laurens.kanbanboard.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.laurens.kanbanboard.utilities.JPACRUDInterface;
import com.laurens.kanbanboard.utilities.JPAConnectionManager;

public class UserJPACRUD implements JPACRUDInterface<User> {

	private JPAConnectionManager jpaConnectionManager;
	private EntityManager entityManager;

	public UserJPACRUD() {
		this.jpaConnectionManager = JPAConnectionManager.getJPAConnectionManager("kanbanboard");
		this.entityManager = jpaConnectionManager.getEntityManager();
	}

	public User create(User user) {
		begin();
		entityManager.persist(user);
		commit();
		return user;
	}

	public boolean update(User user) {
		begin();
		entityManager.persist(user);
		commit();
		return true;
	}

	public void deleteById(User user) {
		begin();
		entityManager.refresh(user);
		commit();
	}

	public User readOneById(long id) {
		entityManager.find(User.class, id);
		return null;
	}

	public List<User> readAll() {
		TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM USER k", User.class);
		List<User> users = typedQuery.getResultList();
		return users;
	}

	private void begin() {
		entityManager.getTransaction().begin();
	}

	private void commit() {
		entityManager.getTransaction().commit();
	}
}
