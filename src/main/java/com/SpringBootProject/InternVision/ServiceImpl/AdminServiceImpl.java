package com.SpringBootProject.InternVision.ServiceImpl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootProject.InternVision.Entity.Admin;
import com.SpringBootProject.InternVision.Repository.AdminRepo;
import com.SpringBootProject.InternVision.Service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepo adminRepo;
	
	@Override
	public Admin createAdmin(Admin admin) {
		Admin admins = adminRepo.save(admin);
		return admins;
	}

	@Override
	public Admin getAdmin(int id) {
		Optional<Admin> admins = adminRepo.findById(id);
		
		if(admins.isPresent()) {
			return admins.get();
		}
		return null;
	}

	@Override
	public void deleteAdmin(int id) {
		adminRepo.deleteById(id);
		
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		Admin existingAdmin = adminRepo.findById(admin.getId()).get();
		existingAdmin.setFullname(admin.getFullname());
		existingAdmin.setEmail(admin.getEmail());
		Admin updateAdmin = adminRepo.save(existingAdmin);
		return updateAdmin;
	}

}
