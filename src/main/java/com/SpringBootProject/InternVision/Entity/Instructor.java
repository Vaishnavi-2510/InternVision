package com.SpringBootProject.InternVision.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instructorid;
	private String fullname;
	
	private String email;
	private String department;
	
	//one instructor can have many interns
	@OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("instructor")
	private List<Intern> intern;
	
	
	@OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("instructor")
	private List<Task> task;
	
}
