package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControlMeIfYouCan {
	
	@GetMapping
	public String test()
	{
		return "I am working";
	}

}