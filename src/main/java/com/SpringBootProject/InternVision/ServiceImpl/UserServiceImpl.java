package com.SpringBootProject.InternVision.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SpringBootProject.InternVision.Entity.User;
import com.SpringBootProject.InternVision.Repository.UserRepo;
import com.SpringBootProject.InternVision.Service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;

	@Override
	public User createUser(User user) {
		User users = userRepo.save(user);
		return users;
	}

	@Override
	public User getUser(int id) {
		Optional<User> users = userRepo.findById(id);
		
		if(users.isPresent()) {
			return users.get();
		}
		return null;
	}

	@Override
	public void deleteUser(int id) {
		
		userRepo.deleteById(id);
	}

	@Override
	public User updateUser(User user) {
		User existingUser = userRepo.findById(user.getId()).get();
		existingUser.setUsername(user.getUsername());
		existingUser.setPassword(user.getPassword());
		User updateUser = userRepo.save(existingUser);
		return updateUser;
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
		
	}

	

	
}
