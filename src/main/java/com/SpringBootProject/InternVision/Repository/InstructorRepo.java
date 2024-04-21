package com.SpringBootProject.InternVision.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootProject.InternVision.Entity.Instructor;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Integer>{

}
