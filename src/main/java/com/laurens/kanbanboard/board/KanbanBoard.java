package com.laurens.kanbanboard.board;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.laurens.kanbanboard.board.doing.DoingTask;
import com.laurens.kanbanboard.board.done.DoneTask;
import com.laurens.kanbanboard.board.todo.ToDoTask;
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
	private List<User> users;
	

//	@Transient
	@OneToMany
	@JoinColumn(name = "KANDBANBOARD_ID")
	private List<ToDoTask> toDoTasks;
	@Transient
	private List<DoingTask> doingTasks;
	@Transient
	private List<DoneTask> doneTasks;

	public KanbanBoard() {

	}

	public KanbanBoard(String nameOfKanbanBoard, List<User> listOfUsers) {
		this.nameOfKanbanBoard = nameOfKanbanBoard;
		this.users = listOfUsers;
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
		return users;
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
