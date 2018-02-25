package com.laurens.kanbanboard.board.todo;

import java.util.List;


public class ToDoTaskService {

	private ToDoTaskJPACRUD toDoTaskJPACRUD;

	public ToDoTaskService() {
		this.toDoTaskJPACRUD = new ToDoTaskJPACRUD();
	}

	public ToDoTask create(ToDoTask toDoTask) {
		toDoTaskJPACRUD.create(toDoTask);
		return toDoTask;
	}

	public boolean update(ToDoTask toDoTask) {
		toDoTaskJPACRUD.update(toDoTask);
		return true;
	}

	public void delete(ToDoTask toDoTask) {
		toDoTaskJPACRUD.delete(toDoTask);
	}

	public ToDoTask readOneById(long id) {
		ToDoTask toDoTask = toDoTaskJPACRUD.readOneById(id);
		return toDoTask;
	}

	public List<ToDoTask> readAll() {
		List<ToDoTask> toDoTasks = toDoTaskJPACRUD.readAll();
		return toDoTasks;
	}
}
