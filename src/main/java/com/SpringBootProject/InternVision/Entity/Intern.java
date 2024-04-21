package com.SpringBootProject.InternVision.Entity;

import java.util.Date;
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
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="InternTable")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Intern {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int internid;
	@NotBlank(message = "name field not be empty")
    private String fullname;
    private String studentaddress;
    @Email
    private String emailId;
	private Long mobileno;
	private Date dob;
    private String duration;
	private Long monthlystipend;
	private String worklocation;
	private Date joiningdate;
    private String mode;
    private String domain;

    //many student can be mapped with one instructor 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructorid")
   @JsonIgnoreProperties("intern")
    private Instructor instructor;
    
 //   one intern mapped with many task
	@OneToMany(mappedBy = "intern", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("intern")
	private List<Task> task;
}
