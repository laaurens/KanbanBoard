package com.laurens.kanbanboard.board;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.laurens.kanbanboard.utilities.JPACRUDInterface;
import com.laurens.kanbanboard.utilities.JPAConnectionManager;

public class KanbanBoardJPACRUD implements JPACRUDInterface<KanbanBoard> {

	private JPAConnectionManager jpaConnectionManager;
	private EntityManager entityManager;

	public KanbanBoardJPACRUD() {
		this.entityManager = jpaConnectionManager.getEntityManager();
	}

	public KanbanBoard create(KanbanBoard kanbanBoard) {
		begin();
		entityManager.persist(kanbanBoard);
		commit();
		return kanbanBoard;
	}

	public boolean update(KanbanBoard kanbanBoard) {
		begin();
		entityManager.persist(kanbanBoard);
		commit();
		return true;
	}

	public void deleteById(KanbanBoard kanbanBoard) {
		begin();
		entityManager.refresh(kanbanBoard);
		commit();
	}

	public KanbanBoard readOneById(long id) {
		entityManager.find(KanbanBoard.class, id);
		return null;
	}

	public List<KanbanBoard> readAll() {
		TypedQuery<KanbanBoard> typedQuery = entityManager.createQuery("SELECT k FROM KANBANBOARDS k",
				KanbanBoard.class);
		List<KanbanBoard> kanbanBoards = typedQuery.getResultList();
		return kanbanBoards;
	}

	private void begin() {
		entityManager.getTransaction().begin();
	}

	private void commit() {
		entityManager.getTransaction().commit();
	}
}
