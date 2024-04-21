package com.SpringBootProject.InternVision.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootProject.InternVision.Entity.Task;
import com.SpringBootProject.InternVision.Repository.TaskRepo;
import com.SpringBootProject.InternVision.Service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	TaskRepo taskRepo;
	
	@Override
	public Task createTask(Task task) {
		Task tasks = taskRepo.save(task);
		return tasks;
	}

	@Override
	public Task getTask(int id) {
		Optional<Task> tasks = taskRepo.findById(id);
		
		if(tasks.isPresent()) {
			return tasks.get();
		}
		return null;
	}

	@Override
	public void deleteTask(int id) {
		
		taskRepo.deleteById(id);
	}

	@Override
	public List<Task> getAllTask() {
		
		return taskRepo.findAll();
	}

	@Override
	public Task updateTask(Task task) {
		Task existingTask = taskRepo.findById(task.getTaskid()).get();
		existingTask.setDescription(task.getDescription());
		existingTask.setStartDate(task.getStartDate());
		existingTask.setEndDate(task.getEndDate());
		existingTask.setStatus(task.getStatus());
		Task upsateTask = taskRepo.save(existingTask);
		return upsateTask;
	}
	
	

}
