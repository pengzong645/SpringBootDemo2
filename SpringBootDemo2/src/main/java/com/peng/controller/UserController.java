package com.peng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.peng.pojo.User;
import com.peng.service.UserService;
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@GetMapping("/findUser")
	public User findOne(int id) {
		System.out.println("userService="+userService);
		User user=new User();
		user.setId(id);
		return userService.findOne(user);
	}
	@GetMapping("/getUsers")
	public List<User> getUsers() {
		System.out.println("------getUsers()--------");
		return userService.getUsers();
	}
	@GetMapping("/deleteUser")
	public String deleteUser(int id) {
		System.out.println("-------deleteUser(id="+id+")---------");
		userService.delete(id);
		return "success";
	} 
	@PostMapping("/updateUser")
	public String updateUser(@RequestBody User user) {
		System.out.println("------updateUser(user="+user+")------");
		userService.update(user);
		return "success";
	}
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		System.out.println("-----addUser(user="+user+")----");
		userService.saveUser(user);
		return "success";
	}

}
