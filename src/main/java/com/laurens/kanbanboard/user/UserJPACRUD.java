package com.laurens.kanbanboard.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.laurens.kanbanboard.utilities.JPACRUDInterface;
import com.laurens.kanbanboard.utilities.JPAConnectionManager;


public class UserJPACRUD implements JPACRUDInterface<User> {

	private JPAConnectionManager jpaConnectionManager;
	private EntityManager entityManager;

//	JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager); 
	
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
		User user = entityManager.find(User.class, id);
		return user;
	}

	// public User readByName(String userName) {
	// TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM USERS
	// u WHERE u.userName =:name",
	// User.class);
	// typedQuery.setParameter("name", userName);
	// User user = typedQuery.getResultList().get(0);
	// return user;
	//
	// }

	public List<User> readByName(String userName) {
		TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.readByName", User.class);
		typedQuery.setParameter("username", userName);
		List<User> users = typedQuery.getResultList();
		return users;

	}
	
	
//	public User readByName(String userName) {
//		QUser user = QUser.user;
//	return user;
//
//}

	public List<User> readAll() {
		TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.readAll", User.class);

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
