package com.SpringBootProject.InternVision.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootProject.InternVision.Entity.Evaluation;
import com.SpringBootProject.InternVision.Repository.EvaluationRepo;
import com.SpringBootProject.InternVision.Service.EvaluationService;

@Service
public class EvaluationServiceImpl implements EvaluationService{

	@Autowired
	EvaluationRepo evaluationRepo;
	
	@Override
	public Evaluation createEvaluation(Evaluation evaluation) {
		Evaluation evaluations = evaluationRepo.save(evaluation);
		return evaluations;
	}

	@Override
	public Evaluation getEvaluation(int id) {
		Optional<Evaluation> evaluations = evaluationRepo.findById(id);
		
		if(evaluations.isPresent()) {
			return evaluations.get();
		}
		return null;
	}

	@Override
	public void deleteEvaluation(int id) {
		evaluationRepo.deleteById(id);
		
	}

	@Override
	public Evaluation updateEvaluation(Evaluation evaluation) {
		Evaluation existingEvaluation = evaluationRepo.findById(evaluation.getEvaluationId()).get();
		existingEvaluation.setEvaluationId(evaluation.getEvaluationId());
		existingEvaluation.setScore(evaluation.getScore());
		existingEvaluation.setFeedback(evaluation.getFeedback());
		Evaluation updEvaluation = evaluationRepo.save(existingEvaluation);
		return updEvaluation;
	}

	@Override
	public List<Evaluation> getAllEvaluation() {
		
		return evaluationRepo.findAll();
	}

}
