package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dto.TeacherDetails;

public interface TeacherRepo extends JpaRepository<TeacherDetails, Integer> {
	

}
