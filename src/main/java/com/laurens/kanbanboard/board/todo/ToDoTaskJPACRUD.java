package com.laurens.kanbanboard.board.todo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import com.laurens.kanbanboard.utilities.JPACRUDInterface;
import com.laurens.kanbanboard.utilities.JPAConnectionManager;

public class ToDoTaskJPACRUD implements JPACRUDInterface<ToDoTask>{

	private JPAConnectionManager jpaConnectionManager;
	private EntityManager entityManager;

	public ToDoTaskJPACRUD() {
		this.jpaConnectionManager = JPAConnectionManager.getJPAConnectionManager("kanbanboard");
		this.entityManager = jpaConnectionManager.getEntityManager();
	}

	public ToDoTask create(ToDoTask toDoTask) {
		begin();
		entityManager.persist(toDoTask);
		commit();
		return toDoTask;
	}

	public boolean update(ToDoTask toDoTask) {
		begin();
		entityManager.persist(toDoTask);
		commit();
		return true;
	}

	public void delete(ToDoTask toDoTask) {
		begin();
		entityManager.remove(toDoTask);
		commit();
	}

	public ToDoTask readOneById(long id) {
		entityManager.find(ToDoTask.class, id);
		return null;
	}

	public List<ToDoTask> readAll() {
		TypedQuery<ToDoTask> typedQuery = entityManager.createQuery("SELECT d FROM TODO_TASKS d", ToDoTask.class);
		List<ToDoTask> toDoTasks = typedQuery.getResultList();
		return toDoTasks;
	}

	private void begin() {
		entityManager.getTransaction().begin();
	}

	private void commit() {
		entityManager.getTransaction().commit();
	}

}
