package com.laurens.kanbanboard.utilities;

import java.util.ArrayList;
import java.util.List;
import com.laurens.kanbanboard.board.KanbanBoard;
import com.laurens.kanbanboard.board.KanbanBoardJPACRUD;
import com.laurens.kanbanboard.board.doing.DoingTask;
import com.laurens.kanbanboard.board.doing.DoingTaskJPACRUD;
import com.laurens.kanbanboard.user.User;
import com.laurens.kanbanboard.user.UserJPACRUD;

public class DatabaseDummyData {

	JPAConnectionManager jpaConnectionManager;
	JPACRUDInterface<User> userJPACRUD;
	JPACRUDInterface<KanbanBoard> kanbanboardJPACRUD;
	JPACRUDInterface<DoingTask> doingTaskJPACRUD;

	public DatabaseDummyData() {
		this.userJPACRUD = new UserJPACRUD();
		this.kanbanboardJPACRUD = new KanbanBoardJPACRUD();
		this.doingTaskJPACRUD = new DoingTaskJPACRUD();
		this.jpaConnectionManager = JPAConnectionManager.getJPAConnectionManager("kanbanboard");
	}

	public void run() {
		User user1 = new User("Laurens");
		User user2 = new User("Henning");
		User user3 = new User("Dieter");
		User user4 = new User("Clemens");

		List<User> listOfUsers1 = new ArrayList<User>();
		listOfUsers1.add(user1);
		listOfUsers1.add(user2);
		List<User> listOfUsers2 = new ArrayList<User>();
		listOfUsers2.add(user1);
		listOfUsers2.add(user3);

		KanbanBoard kanbanboard1 = new KanbanBoard("KanbanBoard1 ohne User");
		KanbanBoard kanbanboard2 = new KanbanBoard("KanbanBoard2 mit L und H", listOfUsers1);
		KanbanBoard kanbanboard3 = new KanbanBoard("KanbanBoard3 mit L und D", listOfUsers2);

		DoingTask doingTask1 = new DoingTask(user1, "Hallo dieser Eintrag ist von User1 (Laurens)");
		DoingTask doingTask2 = new DoingTask(user2, "bla bla bla");
		
		doingTaskJPACRUD.create(doingTask1);
		doingTaskJPACRUD.create(doingTask2);
		kanbanboardJPACRUD.create(kanbanboard1);
		kanbanboardJPACRUD.create(kanbanboard2);
		kanbanboardJPACRUD.create(kanbanboard3);
		userJPACRUD.create(user4);

		jpaConnectionManager.closeEntityManagerFactory();

	}
}
