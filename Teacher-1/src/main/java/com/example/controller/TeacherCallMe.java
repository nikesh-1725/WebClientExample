package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.TeacherDetails;
import com.example.repository.TeacherRepo;


@RestController
public class TeacherCallMe {

	@Autowired
	TeacherRepo repo;

	@GetMapping
	public String test() {
		return "I am Working";
	}

	@PostMapping("/save")
	public String saveTeacherDetails(@RequestBody TeacherDetails detail) {
		repo.save(detail);
		return detail.toString();
	}

}
