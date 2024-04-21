package com.SpringBootProject.InternVision.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootProject.InternVision.Entity.Admin;
import com.SpringBootProject.InternVision.Service.AdminService;

import jakarta.validation.Valid;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PostMapping("/admin")
	public Admin saveAdmin(@Valid @RequestBody Admin admin) {
		return adminService.createAdmin(admin);
		
	}
	
	@GetMapping("/admin/{id}")
	public Admin getAdminById(@PathVariable("id") int id) {
		return adminService.getAdmin(id);
		
	}
		
	@DeleteMapping("/admin/delete/{id}")
	public void deleteAdmin(@PathVariable int id) {
		adminService.deleteAdmin(id);
		System.out.println("Data deleted successfully");
			}
	
	@PutMapping("/admin/update/{id}")
	public Admin update(@PathVariable int id, @RequestBody Admin admin) {
		admin.setId(id);
		Admin updateAdmin = adminService.updateAdmin(admin);
		return updateAdmin;
	}
	
}
