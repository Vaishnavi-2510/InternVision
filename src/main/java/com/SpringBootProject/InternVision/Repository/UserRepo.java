package com.SpringBootProject.InternVision.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBootProject.InternVision.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
