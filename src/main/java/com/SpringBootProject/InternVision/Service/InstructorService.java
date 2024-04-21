package com.SpringBootProject.InternVision.Service;

import java.util.List;

import com.SpringBootProject.InternVision.Entity.Instructor;

public interface InstructorService {

	Instructor createInstructor(Instructor instructor);
	Instructor getInstructor(int id);
	void deleteInstructor(int id);
	Instructor updateInstructor(Instructor instructor);
	List<Instructor> getAllInstructor();
}
