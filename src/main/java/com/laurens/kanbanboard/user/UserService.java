package com.laurens.kanbanboard.user;

import java.util.List;
import com.laurens.kanbanboard.utilities.ServiceInterface;

public class UserService implements ServiceInterface<User> {

	private UserJPACRUD userJPACRUD;

	public UserService() {
		this.userJPACRUD = new UserJPACRUD();
	}

	public User create(User user) {
		userJPACRUD.create(user);
		return user;
	}

	public boolean update(User user) {
		userJPACRUD.update(user);
		return true;
	}

	public void delete(User user) {
		userJPACRUD.delete(user);
	}

	public User readOneById(long id) {
		User user = userJPACRUD.readOneById(id);
		return user;
	}

	public List<User> readAll() {
		List<User> users = userJPACRUD.readAll();
		return users;
	}

}
