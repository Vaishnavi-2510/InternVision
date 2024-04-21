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

import com.SpringBootProject.InternVision.Entity.Instructor;
import com.SpringBootProject.InternVision.Service.InstructorService;

import jakarta.validation.Valid;


@RestController
public class InstructorController {
	@Autowired
	InstructorService instructorService;
	
	@PostMapping("/instructor")
	//@RequestBody - postman sent the request in the JSON format then requestbody translate it into the java object
	public Instructor saveInstructor(@Valid @RequestBody Instructor instructor) {
		
		return instructorService.createInstructor(instructor);
		
	}
	@GetMapping("/instructor/{id}")
	public Instructor getInstructorById(@PathVariable("id") int id) {
		
		return instructorService.getInstructor(id);
	}
	
	@DeleteMapping("/instructor/delete/{id}")
	public void deleteInstructor(@PathVariable int id) {
		instructorService.deleteInstructor(id);
		System.out.println("Data deleted successfully");

	}
	
	@PutMapping("/instructor/update/{id}")
	public Instructor upInstructor(@PathVariable("id") int id, @RequestBody Instructor instructor) {
		instructor.setInstructorid(id);
		Instructor upInstructor = instructorService.updateInstructor(instructor);
		return upInstructor;
	}
	
	@GetMapping("/instructor/getAllData")
	public List<Instructor> getAllInstructor(){
		List<Instructor> instructor = instructorService.getAllInstructor();
		return instructor;
	}
}
