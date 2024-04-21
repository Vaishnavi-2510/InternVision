package com.SpringBootProject.InternVision.ServiceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootProject.InternVision.Entity.Instructor;
import com.SpringBootProject.InternVision.Repository.InstructorRepo;
import com.SpringBootProject.InternVision.Service.InstructorService;
@Service
public class InstructorServiceImpl implements InstructorService{

	@Autowired
	InstructorRepo instructorRepo;
	
	@Override
	public Instructor createInstructor(Instructor instructor) {
		Instructor instructors = instructorRepo.save(instructor);
		return instructors;
	}

	@Override
	public Instructor getInstructor(int id) {
		Optional<Instructor> instructors = instructorRepo.findById(id);
		
		if(instructors.isPresent()) {
			return instructors.get();
		}
		return null;
	}

	@Override
	public void deleteInstructor(int id) {
		instructorRepo.deleteById(id);
	
	}

	@Override
	public Instructor updateInstructor(Instructor instructor) {
		Instructor existingInstructor = instructorRepo.findById(instructor.getInstructorid()).get();
		existingInstructor.setFullname(instructor.getFullname());
		existingInstructor.setEmail(instructor.getEmail());
		existingInstructor.setDepartment(instructor.getDepartment());
		Instructor upInstructor = instructorRepo.save(existingInstructor);
		return upInstructor;
	}

	@Override
	public List<Instructor> getAllInstructor() {
		return instructorRepo.findAll();
	}

}
