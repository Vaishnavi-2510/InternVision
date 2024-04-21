package com.SpringBootProject.InternVision.Service;

import java.util.List;

import com.SpringBootProject.InternVision.Entity.Evaluation;

public interface EvaluationService {

	Evaluation createEvaluation(Evaluation evaluation);
	Evaluation getEvaluation(int id);
	void deleteEvaluation(int id);
	Evaluation updateEvaluation(Evaluation evaluation);
	List<Evaluation> getAllEvaluation();
}
