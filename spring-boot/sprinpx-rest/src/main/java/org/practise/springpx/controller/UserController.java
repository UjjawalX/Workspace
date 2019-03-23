package org.practise.springpx.controller;

import java.util.List;

import org.practise.springpx.model.User;
import org.practise.springpx.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
	UserService userService = new UserService();

	@GetMapping(path = "/userService")
	@ResponseBody
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@GetMapping(path = "/userService/{id}")
	@ResponseBody
	public User getUser(@PathVariable("id") String id) {
		return userService.getUser(id);
	}

	@PostMapping(path = "/userService")
	@ResponseBody
	public User postUser(@RequestBody User user) {
		return userService.postUser(user);
	}

}
