package com.laurens.kanbanboard.board.todo;

import java.util.List;
import javax.persistence.EntityManager;
import com.laurens.kanbanboard.utilities.JPACRUDInterface;
import com.laurens.kanbanboard.utilities.JPAConnectionManager;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class ToDoTaskJPACRUD implements JPACRUDInterface<ToDoTask>{

	private JPAConnectionManager jpaConnectionManager;
	private EntityManager entityManager;
	private JPAQueryFactory jpaQueryFactory;
	private QToDoTask toDoTask;

	public ToDoTaskJPACRUD() {
		this.jpaConnectionManager = JPAConnectionManager.getJPAConnectionManager("kanbanboard");
		this.entityManager = jpaConnectionManager.getEntityManager();
		this.jpaQueryFactory = jpaConnectionManager.getJPAQueryFactory();
		this.toDoTask = QToDoTask.toDoTask;
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
		ToDoTask toDoTask = entityManager.find(ToDoTask.class, id);
		return toDoTask;
	}

	public List<ToDoTask> readAll() {
		List<ToDoTask> toDoTasks = jpaQueryFactory.selectFrom(toDoTask).fetch();
		return toDoTasks;
	}

	private void begin() {
		entityManager.getTransaction().begin();
	}

	private void commit() {
		entityManager.getTransaction().commit();
	}

}
