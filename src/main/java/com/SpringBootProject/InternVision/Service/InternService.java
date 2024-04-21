package com.SpringBootProject.InternVision.Service;

import java.util.List;

import com.SpringBootProject.InternVision.Entity.Intern;

public interface InternService {

	Intern createIntern(Intern intern);
	Intern getIntern(int id);
	void deleteIntern(int id);
	Intern updateIntern(Intern intern);
	List<Intern>getAllIntern();
}
