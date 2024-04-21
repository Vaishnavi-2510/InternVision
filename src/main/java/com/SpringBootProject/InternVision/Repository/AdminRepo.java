package com.SpringBootProject.InternVision.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootProject.InternVision.Entity.Admin;
@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

}
