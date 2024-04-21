package com.SpringBootProject.InternVision.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootProject.InternVision.Entity.Intern;

@Repository
public interface InternRepo extends JpaRepository<Intern, Integer>{

}
