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

import com.SpringBootProject.InternVision.Entity.Task;
import com.SpringBootProject.InternVision.Service.TaskService;

import jakarta.validation.Valid;

@RestController
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@PostMapping("/task")
	public Task saveTask(@Valid @RequestBody Task task) {
		return taskService.createTask(task);
		
	}
	
	@GetMapping("/task/{id}")
	public Task getTaskById(@PathVariable("id") int id) {
		return taskService.getTask(id);
		
	}
	
	@DeleteMapping("/task/delete/{id}")
	public void deleteTask(@PathVariable int id) {
		taskService.deleteTask(id);
		System.out.println("Data deleted successfully");

	}
	
	@GetMapping("task/getAllData")
	public List<Task> getAllTask(){
		List<Task> tasks = taskService.getAllTask();
		return tasks;
		
	}
	
	@PutMapping("/task/update/{id}")
	public Task updateTask(@PathVariable("id") int id, @RequestBody Task task) {
		task.setTaskid(id);
		Task updateTask = taskService.updateTask(task);
		return updateTask;
		}
}
