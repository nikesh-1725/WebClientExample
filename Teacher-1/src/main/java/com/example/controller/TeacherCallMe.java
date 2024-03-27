package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Member;
import com.example.dto.TeacherDetails;
import com.example.repository.TeacherRepo;
import com.example.service.TeacherService;


@RestController
public class TeacherCallMe {

	
	TeacherRepo repo;
	TeacherService service;
	
	public TeacherCallMe(TeacherRepo repo, TeacherService service) {
		this.repo = repo;
		this.service = service;
	}

	@GetMapping
	public String test() {
		return "I am Working and I am Teacher";
	}
	
	@GetMapping("/allTeacher")
	public List<TeacherDetails> getAllMembers()
	{
		List<TeacherDetails> list = repo.findAll();
		return list;
	}

	@PostMapping("/save")
	public String saveTeacherDetails(@RequestBody TeacherDetails detail) {
		repo.save(detail);
		return detail.toString();
	}
	
	@PostMapping("/saveAll")
	public List<TeacherDetails> saveTeacherDetail(@RequestBody List<TeacherDetails> detail) {
		repo.saveAll(detail);
		return detail;
	}
	
	@GetMapping("/getAllMembers/{id}")
	public List<String> getAllMembers(@PathVariable Integer id)
	{
		return service.getMembersById(id);
	}
	


}
