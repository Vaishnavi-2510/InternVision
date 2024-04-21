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

import com.SpringBootProject.InternVision.Entity.Intern;
import com.SpringBootProject.InternVision.Service.InternService;

import jakarta.validation.Valid;


@RestController
public class InternController {

	@Autowired
	InternService internService;
	
	@PostMapping("/intern")
	public Intern saveUser(@Valid @RequestBody Intern intern) {
		return internService.createIntern(intern);
	}
	
	@GetMapping("/intern/{id}")
	public Intern getInternById(@PathVariable("id") int id) {
		return internService.getIntern(id);
			 
	}
	
	@DeleteMapping("/intern/delete/{id}")
	public void deleteIntern(@PathVariable int id) {
		internService.deleteIntern(id);
		System.out.println("Data deleted successfully");
	}
	
	@PutMapping("/intern/update/{id}")
	public Intern update(@PathVariable("id") int id, @RequestBody Intern intern) {
		intern.setInternid(id);
		Intern updateIntern = internService.updateIntern(intern);
		return updateIntern;
		
	}
	@GetMapping("intern/getAllData")
	public List<Intern>getAllIntern(){
		List<Intern> interns = internService.getAllIntern();
		return interns;
		
	}
	
}
