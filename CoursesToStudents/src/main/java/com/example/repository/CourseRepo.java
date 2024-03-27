package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

	@Query("SELECT c_name FROM Course WHERE c_id=:id")
	public String findCourseNameById(Integer id);
	
	@Query("SELECT t_id FROM TeacherDetails WHERE t_name = :name")
	public int findIdOfTeacherDetails(String name);
	
	
	@Query("SELECT tc_name FROM Course WHERE c_name=:name")
	public List<String> allTeacherNameByCourse(String name);
	
	
	

}
