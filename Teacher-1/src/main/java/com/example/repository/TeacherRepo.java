package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.dto.TeacherDetails;

@Repository
public interface TeacherRepo extends JpaRepository<TeacherDetails, Integer> {
	
	   @Query("SELECT t_name FROM TeacherDetails WHERE t_id = :id")
	   String findNameById(@Param("id") Integer id);
	   
	   

}
