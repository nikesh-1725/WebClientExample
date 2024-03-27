package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Course;
import com.example.entity.TeacherDetails;
import com.example.repository.CourseRepo;
import com.example.service.CourseService;

@RestController
public class CourseController {
	
	
	CourseRepo repo;
	
	CourseService service;
	
	

	public CourseController(CourseRepo repo, CourseService service) {
		this.repo = repo;
		this.service = service;
	}

	@GetMapping
	public String test()
	{
		return "I am working and I am a Member";
	}
	
	@GetMapping("/allMembers")
	public List<Course> getAllCourses()
	{
		List<Course> list = repo.findAll();
		return list;
	}
	
	@PostMapping("/save")
	public String saveCourseDetails(@RequestBody Course detail) {
		repo.save(detail);
		return detail.toString();
	}
	
	@GetMapping("/getAll/{id}")
	public Map<String, Object> getAllListByCourseId(@PathVariable Integer id)
	{
		return service.getAllCourse(id);
	}
	
	@PostMapping("/postAllCourses")
	public List<TeacherDetails> postCall(@RequestBody List<TeacherDetails> teacher)
	{
		return service.postAllCourse();
		}

}
