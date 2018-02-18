package com.laurens.kanbanboard.utilities;

import com.laurens.kanbanboard.user.User;
import com.laurens.kanbanboard.user.UserJPACRUD;

public class DatabaseDummyData {

	JPAConnectionManager jpaConnectionManager;
	JPACRUDInterface<User> userJPACRUD;

	public DatabaseDummyData() {
		 this.userJPACRUD = new UserJPACRUD();
		 this.jpaConnectionManager = JPAConnectionManager.getJPAConnectionManager("kanbanboard");
		 }

	public void run() {
		User user1 = new User("Michael");
		userJPACRUD.create(user1);
		
		
		
		jpaConnectionManager.closeEntityManagerFactory();
		
		
	}
}
