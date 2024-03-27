package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Member;
import com.example.respoitory.StudentRepo;

@RestController
public class ControlMeIfYouCan {
	
	StudentRepo repo;
	
	
	public ControlMeIfYouCan(StudentRepo repo) {
		this.repo = repo;
	}

	@GetMapping
	public String test()
	{
		return "I am working and I am a Member";
	}
	
	@GetMapping("/allMembers")
	public List<Member> getAllMembers()
	{
		List<Member> list = repo.findAll();
		return list;
	}
	
	@PostMapping("/save")
	public String saveTeacherDetails(@RequestBody Member detail) {
		repo.save(detail);
		return detail.toString();
	}
	
	
		
	

}
