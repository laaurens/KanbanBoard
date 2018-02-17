package com.laurens.kanbanboard.board;

import java.util.List;
import com.laurens.kanbanboard.board.tasks.DoingTask;
import com.laurens.kanbanboard.board.tasks.DoneTask;
import com.laurens.kanbanboard.board.tasks.ToDoTask;

public class KanbanBoard {

	private long kanbanBoardId;
	private User user;
	private List<ToDoTask> toDoTasks;
	private List<DoingTask> doingTasks;
	private List<DoneTask> doneTasks;

	public KanbanBoard() {

	}

	public KanbanBoard(User user) {
		this.user = user;
	}

	public long getKanbanBoardId() {
		return kanbanBoardId;
	}

}
