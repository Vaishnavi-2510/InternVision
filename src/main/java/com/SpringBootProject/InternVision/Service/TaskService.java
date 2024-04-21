package com.SpringBootProject.InternVision.Service;

import java.util.List;

import com.SpringBootProject.InternVision.Entity.Task;

public interface TaskService {
	
	Task createTask(Task task);
	Task getTask(int id);
	void deleteTask(int id);
	List<Task>getAllTask();
	Task updateTask(Task task);
}
