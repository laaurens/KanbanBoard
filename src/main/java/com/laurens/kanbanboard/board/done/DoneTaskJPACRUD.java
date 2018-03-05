package com.laurens.kanbanboard.board.done;

import java.util.List;
import javax.persistence.EntityManager;
import com.laurens.kanbanboard.utilities.JPACRUDInterface;
import com.laurens.kanbanboard.utilities.JPAConnectionManager;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class DoneTaskJPACRUD implements JPACRUDInterface<DoneTask> {

	private JPAConnectionManager jpaConnectionManager;
	private EntityManager entityManager;
	private JPAQueryFactory jpaQueryFactory;
	private QDoneTask doneTask;

	public DoneTaskJPACRUD() {
		this.jpaConnectionManager = JPAConnectionManager.getJPAConnectionManager("kanbanboard");
		this.entityManager = jpaConnectionManager.getEntityManager();
		this.jpaQueryFactory = jpaConnectionManager.getJPAQueryFactory();
		this.doneTask = QDoneTask.doneTask;
		
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
		DoneTask doneTask = entityManager.find(DoneTask.class, id);
		return doneTask;
	}

	public List<DoneTask> readAll() {
		List<DoneTask> doneTasks = jpaQueryFactory.selectFrom(doneTask).fetch();
		return doneTasks;
	}

	private void begin() {
		entityManager.getTransaction().begin();
	}

	private void commit() {
		entityManager.getTransaction().commit();
	}
}
