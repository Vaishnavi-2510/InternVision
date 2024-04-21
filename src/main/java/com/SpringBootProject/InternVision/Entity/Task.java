package com.SpringBootProject.InternVision.Entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskid;
    private String description;
    @NotBlank(message = "status should not be blank")
    private String status;
    private Date startDate;
    private Date endDate;
	
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("task")
    private List<Evaluation> evaluation;
    
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "internid")
	@JsonIgnoreProperties("task")
	private Intern intern;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructorid")
    @JsonIgnoreProperties("task")
    private Instructor instructor;

}
