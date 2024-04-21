package com.SpringBootProject.InternVision.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootProject.InternVision.Entity.Intern;
import com.SpringBootProject.InternVision.Repository.InternRepo;
import com.SpringBootProject.InternVision.Service.InternService;

@Service
public class InternServiceImpl implements InternService {

	@Autowired
	InternRepo internRepo;

	@Override
	public Intern createIntern(Intern intern) {
		Intern interns = internRepo.save(intern);
		return interns;
	}

	@Override
	public Intern getIntern(int id) {
		Optional<Intern> interns = internRepo.findById(id);
		
		if(interns.isPresent()) {
			return interns.get();
		}
		return null;
	}

	@Override
	public void deleteIntern(int id) {
		internRepo.deleteById(id);
		
	}

	@Override
	public Intern updateIntern(Intern intern) {
		Intern existingIntern = internRepo.findById(intern.getInternid()).get();
		existingIntern.setFullname(intern.getFullname());
		existingIntern.setStudentaddress(intern.getStudentaddress());
		existingIntern.setDob(intern.getDob());
		Intern updateIntern = internRepo.save(existingIntern);
		return updateIntern;
	}

	@Override
	public List<Intern> getAllIntern() {
		return internRepo.findAll();
	}
}
