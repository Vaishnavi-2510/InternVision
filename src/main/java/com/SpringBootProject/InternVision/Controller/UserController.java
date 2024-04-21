package com.SpringBootProject.InternVision.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.SpringBootProject.InternVision.Entity.User;
import com.SpringBootProject.InternVision.Service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	//@RequestBody - postman sent the request in the JSON format then requesbody translate it into the java object
	public User saveUser(@Valid @RequestBody User user) {
		
		return userService.createUser(user);
		
	}
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") int id) {
		
		return userService.getUser(id);
	}
	
	@DeleteMapping("/user/delete/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		System.out.println("Data deleted successfully");
	}
	
	@PutMapping("/user/update/{id}")
	public User updateUser(@PathVariable("id") int id, @RequestBody User user) {
		user.setId(id);
		User updateUser = userService.updateUser(user);
		return updateUser;
	}
	
	@GetMapping("/user/getAllData")
	public List<User> getAllUser(){
		List<User> user = userService.getAllUser();
		return user;
		
	}

}
