package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.entity.Course;
import com.example.entity.TeacherDetails;
import com.example.repository.CourseRepo;

@Service
public class CourseService {

	@Autowired
	private WebClient webClient;

	CourseRepo repo;

	public CourseService(CourseRepo repo, List<Course> courseList) {
		this.repo = repo;
		this.courseList = courseList;
	}

	List<Course> courseList;

	private static final String restUrl = "http://localhost:8080/getAllMembers/";
	
	private static final String postResturl="http://localhost:8080/saveAll";

	public Map<String, Object> getAllCourse(int id) {

		String courseName = repo.findCourseNameById(id);// got the course name with this
		System.out.println(courseName);

		List<String> teachersList = repo.allTeacherNameByCourse(courseName);
		// List<TeacherDetails> teacherDetails = null;
		List<String> response = null;

		for (String str : teachersList) {
			int teacher_id = repo.findIdOfTeacherDetails(str);
			/*
			 * List<String> teacherDetails = webClient.get().uri(restUrl,
			 * teacher_id).retrieve()
			 * .bodyToMono(String.class).collect(Collectors.toList()).share().block();
			 */
			response = webClient.get().uri(restUrl + "{teacher_id}", teacher_id).retrieve().bodyToFlux(String.class)
					.collect(Collectors.toList()).block();
		}
		
		
		JSONArray jsonArray = new JSONArray(response);
		
		String s=jsonArray.toString(4);                     
		
		Map<String, Object> result = new HashMap<>();
		result.put(courseName, s);
		return result;
	}
	
	public List<TeacherDetails> postAllCourse()
	{
		

		List<TeacherDetails> listDetails=new ArrayList<>();
		listDetails.add(new TeacherDetails(5, "Malla", "Johnson Grammer School"));
		listDetails.add(new TeacherDetails(6,"Nalla","NGRI"));
		
		List<TeacherDetails> teacher =webClient.post()
        .uri(postResturl)
        .body(BodyInserters.fromValue(listDetails))
        .retrieve()
        .bodyToFlux(TeacherDetails.class).collectList().block();
		
		return teacher;
	}

}
