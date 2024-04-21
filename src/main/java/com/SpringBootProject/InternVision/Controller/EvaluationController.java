package com.SpringBootProject.InternVision.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootProject.InternVision.Entity.Evaluation;
import com.SpringBootProject.InternVision.Service.EvaluationService;


@RestController
public class EvaluationController {

	@Autowired
	EvaluationService evaluationService;
	
	@PostMapping("/evaluation")
	
	public Evaluation saveEvaluation(@RequestBody Evaluation evaluation) {
		return evaluationService.createEvaluation(evaluation);
		
	}
	
	@GetMapping("/evaluation/{id}")
	public Evaluation getEvaluationById(@PathVariable("id") int id) {
		return evaluationService.getEvaluation(id);
		
	}
	
	@DeleteMapping("/evaluation/delete/{id}")
	public void deleteEvaluation(@PathVariable int id) {
		evaluationService.deleteEvaluation(id);
		System.out.println("Data deleted successfully");
	}

	@PutMapping("/evaluation/update/{id}")
	public Evaluation update(@PathVariable("id") int id,@RequestBody Evaluation evaluation) {
		evaluation.setEvaluationId(id);
		Evaluation updateEvaluation = evaluationService.updateEvaluation(evaluation);
		return updateEvaluation;
	}
	
	@GetMapping("/evaluation/getAllData")
	public List<Evaluation> getAllEvaluation(){
		List<Evaluation> evaluation = evaluationService.getAllEvaluation();
		return evaluation;
		
	}
}
