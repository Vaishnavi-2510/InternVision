package com.SpringBootProject.InternVision.Service;

import com.SpringBootProject.InternVision.Entity.Admin;

public interface AdminService {

	Admin createAdmin(Admin admin);
	Admin getAdmin(int id);
	void deleteAdmin(int id);
	Admin updateAdmin(Admin admin);
}
