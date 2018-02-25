package com.laurens.kanbanboard.board.doing;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.laurens.kanbanboard.utilities.JPACRUDInterface;
import com.laurens.kanbanboard.utilities.JPAConnectionManager;

public class DoingTaskJPACRUD implements JPACRUDInterface<DoingTask>{
	
	private JPAConnectionManager jpaConnectionManager;
	private EntityManager entityManager;

	public DoingTaskJPACRUD() {
		this.jpaConnectionManager = JPAConnectionManager.getJPAConnectionManager("kanbanboard");
		this.entityManager = jpaConnectionManager.getEntityManager();
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

	public DoingTask readOneById(long id) {
		entityManager.find(DoingTask.class, id);
		return null;
	}

	public List<DoingTask> readAll() {
		TypedQuery<DoingTask> typedQuery = entityManager.createQuery("SELECT d FROM DOING_TASKS d", DoingTask.class);
		List<DoingTask> doingTasks = typedQuery.getResultList();
		return doingTasks;
	}

	private void begin() {
		entityManager.getTransaction().begin();
	}

	private void commit() {
		entityManager.getTransaction().commit();
	}

}
