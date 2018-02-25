package com.laurens.kanbanboard.user;

import java.util.List;

import javax.persistence.EntityManager;
import com.laurens.kanbanboard.utilities.JPACRUDInterface;
import com.laurens.kanbanboard.utilities.JPAConnectionManager;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class UserJPACRUD implements JPACRUDInterface<User> {

	private JPAConnectionManager jpaConnectionManager;
	private EntityManager entityManager;
	private JPAQueryFactory jpaQueryFactory;
	QUser user;

	public UserJPACRUD() {
		this.jpaConnectionManager = JPAConnectionManager.getJPAConnectionManager("kanbanboard");
		this.entityManager = jpaConnectionManager.getEntityManager();
		this.jpaQueryFactory = jpaConnectionManager.getJPAQueryFactory();
		this.user = QUser.user;
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

	public void deleteById(long id) {
		begin();
		jpaQueryFactory.delete(user).where(user.userId.eq(id)).execute();		
		commit();
	}
	
	public void delete(User user) {
		begin();
		entityManager.remove(user);
		commit();
	}

	public User readOneById(long id) {
		User user = entityManager.find(User.class, id);
		return user;
	}

	public List<User> readByName(String userName) {
		List<User> users = jpaQueryFactory.selectFrom(user).where(user.userName.eq(userName)).fetch();
		return users;

	}

	public List<User> readAll() {
		List<User> users = jpaQueryFactory.selectFrom(user).fetch();
		return users;

	}

	private void begin() {
		entityManager.getTransaction().begin();
	}

	private void commit() {
		entityManager.getTransaction().commit();
	}
}
