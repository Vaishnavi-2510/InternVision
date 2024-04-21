package com.SpringBootProject.InternVision.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootProject.InternVision.Entity.Evaluation;

@Repository
public interface EvaluationRepo extends JpaRepository<Evaluation, Integer>{

}
