package com.laurens.kanbanboard.utilities;

import java.util.ArrayList;
import java.util.List;
import com.laurens.kanbanboard.board.KanbanBoard;
import com.laurens.kanbanboard.board.KanbanBoardJPACRUD;
import com.laurens.kanbanboard.board.doing.DoingTask;
import com.laurens.kanbanboard.board.doing.DoingTaskJPACRUD;
import com.laurens.kanbanboard.board.done.DoneTask;
import com.laurens.kanbanboard.board.done.DoneTaskJPACRUD;
import com.laurens.kanbanboard.board.todo.ToDoTask;
import com.laurens.kanbanboard.board.todo.ToDoTaskJPACRUD;
import com.laurens.kanbanboard.user.User;
import com.laurens.kanbanboard.user.UserJPACRUD;

public class DatabaseDummyData {

	JPAConnectionManager jpaConnectionManager;
	UserJPACRUD userJPACRUD;
	JPACRUDInterface<KanbanBoard> kanbanboardJPACRUD;
	JPACRUDInterface<DoingTask> doingTaskJPACRUD;
	JPACRUDInterface<ToDoTask> toDoTaskJPACRUD;
	JPACRUDInterface<DoneTask> doneTaskJPACRUD;
	
	public DatabaseDummyData() {
		this.userJPACRUD = new UserJPACRUD();
		this.kanbanboardJPACRUD = new KanbanBoardJPACRUD();
		this.doingTaskJPACRUD = new DoingTaskJPACRUD();
		this.toDoTaskJPACRUD = new ToDoTaskJPACRUD();
		this.doneTaskJPACRUD = new DoneTaskJPACRUD();
		this.jpaConnectionManager = JPAConnectionManager.getJPAConnectionManager("kanbanboard");
	}

	public void run() {
		User user1 = new User("Laurens");
		User user2 = new User("Henning");
		User user3 = new User("Dieter");
		User user4 = new User("Clemens");
		User user5 = new User("Laurens");

		List<User> listOfUsers1 = new ArrayList<User>();
		listOfUsers1.add(user1);
		listOfUsers1.add(user2);
		List<User> listOfUsers2 = new ArrayList<User>();
		listOfUsers2.add(user1);
		listOfUsers2.add(user3);
		listOfUsers2.add(user5);

		KanbanBoard kanbanboard1 = new KanbanBoard("KanbanBoard1 ohne User");
		KanbanBoard kanbanboard2 = new KanbanBoard("KanbanBoard2 mit L und H", listOfUsers1);
		KanbanBoard kanbanboard3 = new KanbanBoard("KanbanBoard3 mit L und D", listOfUsers2);

		DoingTask doingTask1 = new DoingTask(user1, kanbanboard2, "Hallo dieser Eintrag ist von User1 (Laurens)");
		DoingTask doingTask2 = new DoingTask(user2, kanbanboard3, "bla bla bla");
		ToDoTask toDoTask1 = new ToDoTask(user1, kanbanboard1, "TO DO in kanbanboard1");
		ToDoTask toDoTask2 = new ToDoTask(user1, kanbanboard1, "TO DO2 in kanbanboard1");
		DoneTask doneTask1 = new DoneTask(user3, kanbanboard2,"DONE");
		
		toDoTaskJPACRUD.create(toDoTask1);
		toDoTaskJPACRUD.create(toDoTask2);
		doneTaskJPACRUD.create(doneTask1);
		doingTaskJPACRUD.create(doingTask1);
		doingTaskJPACRUD.create(doingTask2);
		kanbanboardJPACRUD.create(kanbanboard1);
		kanbanboardJPACRUD.create(kanbanboard2);
		kanbanboardJPACRUD.create(kanbanboard3);
		userJPACRUD.create(user4);
		userJPACRUD.delete(user4);
		user1.setUserName("LAURENSSSS");
		userJPACRUD.update(user1);
		
		
//		DEBUGG:
		System.out.println("(USERS) READ ALL:" + userJPACRUD.readAll());
		System.out.println("(USERS) READ ONE BY ID:" + userJPACRUD.readOneById(2)); 
		System.out.println("(USERS) READ BY NAME:" + userJPACRUD.readByName("Henning"));
		System.out.println("TODOTASK) READ ALL:" + toDoTaskJPACRUD.readAll());
		System.out.println("DOINGTASK) READ ALL:" + doingTaskJPACRUD.readAll());
		System.out.println("DONETASK) READ ALL:" + doneTaskJPACRUD.readAll());
		
//		

		jpaConnectionManager.closeEntityManagerFactory();

	}
}
