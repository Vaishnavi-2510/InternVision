package com.SpringBootProject.InternVision.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Evaluation 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int evaluationId;  
    private int score;
    private String feedback;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "taskid")
    @JsonIgnoreProperties("evaluation")
    private Task task;
}
