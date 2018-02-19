package com.laurens.kanbanboard.board;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.laurens.kanbanboard.board.tasks.DoingTask;
import com.laurens.kanbanboard.board.tasks.DoneTask;
import com.laurens.kanbanboard.board.tasks.ToDoTask;
import com.laurens.kanbanboard.user.User;

@Entity(name = "KANBANBOARDS")
public class KanbanBoard {

	@Id
	@GeneratedValue
	@Column(name = "KANBANBOARD_ID")
	private long kanbanBoardId;

	@Column(name = "KANBANBOARD_NAME")
	private String nameOfKanbanBoard;

	@ManyToMany(cascade = CascadeType.ALL)
	// @JoinColumn(name = "USER_ID")
	private List<User> listOfUsers;

	@Transient
	private List<ToDoTask> toDoTasks;
	@Transient
	private List<DoingTask> doingTasks;
	@Transient
	private List<DoneTask> doneTasks;

	public KanbanBoard() {

	}

	public KanbanBoard(String nameOfKanbanBoard, List<User> listOfUsers) {
		this.nameOfKanbanBoard = nameOfKanbanBoard;
		this.listOfUsers = listOfUsers;
	}

	public KanbanBoard(String nameOfKanbanBoard) {
		this.nameOfKanbanBoard = nameOfKanbanBoard;
	}

	public long getKanbanBoardId() {
		return kanbanBoardId;
	}

	public String getNameOfKanbanBoard() {
		return nameOfKanbanBoard;
	}

	public void setNameOfKanbanBoard(String nameOfKanbanBoard) {
		this.nameOfKanbanBoard = nameOfKanbanBoard;
	}

	public List<User> getListOfUser() {
		return listOfUsers;
	}

	public List<ToDoTask> getToDoTasks() {
		return toDoTasks;
	}

	public List<DoingTask> getDoingTasks() {
		return doingTasks;
	}

	public List<DoneTask> getDoneTasks() {
		return doneTasks;
	}

}
