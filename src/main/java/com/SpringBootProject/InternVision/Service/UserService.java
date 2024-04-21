package com.SpringBootProject.InternVision.Service;

import java.util.List;

import com.SpringBootProject.InternVision.Entity.User;

public interface UserService {

	User createUser(User user);
	User getUser(int id);
	void deleteUser(int id);
	User updateUser(User user);
	List<User> getAllUser();
}
