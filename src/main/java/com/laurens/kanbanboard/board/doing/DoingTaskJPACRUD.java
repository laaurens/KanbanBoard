package com.laurens.kanbanboard.board.doing;

import java.util.List;

import javax.persistence.EntityManager;
import com.laurens.kanbanboard.utilities.JPACRUDInterface;
import com.laurens.kanbanboard.utilities.JPAConnectionManager;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class DoingTaskJPACRUD implements JPACRUDInterface<DoingTask>{
	
	private JPAConnectionManager jpaConnectionManager;
	private EntityManager entityManager;
	private JPAQueryFactory jpaQueryFactory;
	private QDoingTask doingTask;

	public DoingTaskJPACRUD() {
		this.jpaConnectionManager = JPAConnectionManager.getJPAConnectionManager("kanbanboard");
		this.entityManager = jpaConnectionManager.getEntityManager();
		this.jpaQueryFactory = jpaConnectionManager.getJPAQueryFactory();
		this.doingTask = QDoingTask.doingTask;
	}

	public DoingTask create(DoingTask doingTask) {
		begin();
		entityManager.persist(doingTask);
		commit();
		return doingTask;
	}

	public boolean update(DoingTask doingTask) {
		begin();
		entityManager.persist(doingTask);
		commit();
		return true;
	}

	public void delete(DoingTask doingTask) {
		begin();
		entityManager.remove(doingTask);
		commit();
	}
	
	public void deleteById(long id) {
		begin();
		jpaQueryFactory.delete(doingTask).where(doingTask.doingTaskId.eq(id)).execute();		
		commit();
	}

	public DoingTask readOneById(long id) {
		DoingTask doingTask = entityManager.find(DoingTask.class, id);
		return doingTask;
	}

	public List<DoingTask> readAll() {
		List<DoingTask> doingTasks = jpaQueryFactory.selectFrom(doingTask).fetch();
		return doingTasks;
	}

	private void begin() {
		entityManager.getTransaction().begin();
	}

	private void commit() {
		entityManager.getTransaction().commit();
	}

}
