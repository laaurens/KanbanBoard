package com.laurens.kanbanboard.board.done;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import com.laurens.kanbanboard.utilities.JPACRUDInterface;
import com.laurens.kanbanboard.utilities.JPAConnectionManager;

public class DoneTaskJPACRUD implements JPACRUDInterface<DoneTask> {

	private JPAConnectionManager jpaConnectionManager;
	private EntityManager entityManager;

	public DoneTaskJPACRUD() {
		this.jpaConnectionManager = JPAConnectionManager.getJPAConnectionManager("kanbanboard");
		this.entityManager = jpaConnectionManager.getEntityManager();
	}

	public DoneTask create(DoneTask doingTask) {
		begin();
		entityManager.persist(doingTask);
		commit();
		return doingTask;
	}

	public boolean update(DoneTask doingTask) {
		begin();
		entityManager.persist(doingTask);
		commit();
		return true;
	}

	public void delete(DoneTask doingTask) {
		begin();
		entityManager.remove(doingTask);
		commit();
	}

	public DoneTask readOneById(long id) {
		entityManager.find(DoneTask.class, id);
		return null;
	}

	public List<DoneTask> readAll() {
		TypedQuery<DoneTask> typedQuery = entityManager.createQuery("SELECT d FROM DONE_TASKS d", DoneTask.class);
		List<DoneTask> doneTasks = typedQuery.getResultList();
		return doneTasks;
	}

	private void begin() {
		entityManager.getTransaction().begin();
	}

	private void commit() {
		entityManager.getTransaction().commit();
	}
}
