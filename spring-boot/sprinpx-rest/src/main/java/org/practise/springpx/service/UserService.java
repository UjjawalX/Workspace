package org.practise.springpx.service;

import java.util.ArrayList;
import java.util.List;

import org.practise.springpx.model.User;

public class UserService {
	List<User> usList;

	public UserService() {
		User user = new User();
		User user1 = new User();
		user.setId(10);
		user.setName("high");
		user.setAddress("thisi is address of a special secret agent . Hope u don't want to mess");
		user1.setId(12);
		user1.setName("rajumal");
		user1.setAddress("mi address is in the very edge of a cliff from where you can see the entire county");
		usList = new ArrayList<>();
		usList.add(user);
		usList.add(user1);
	}

	public List<User> getUsers() {
		return usList;
	}

	public User getUser(String id) {
		// TODO Auto-generated method stub
		return usList.stream().filter(idd -> idd.getId() == Integer.parseInt(id)).findFirst().get();
	}

	public User postUser(User user) {
		// TODO Auto-generated method stub
		if (usList.add(user))
			return user;
		else
			return null;

	}
}
