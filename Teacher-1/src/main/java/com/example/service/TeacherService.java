package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dto.Member;
import com.example.dto.TeacherDetails;
import com.example.repository.TeacherRepo;

@Service
public class TeacherService {

	WebClient webClient = WebClient.create();
	
	
	TeacherRepo repo;
	
	public TeacherService(TeacherRepo repo) {
		this.repo = repo;
	}

	private static final String restUrl = "http://localhost:8081/allMembers";

	public List<String> getMembersById(Integer id) {
		// TeacherDetails den=new TeacherDetails();
		
		
			
		String name=repo.findNameById(id);

//		List<Member> allMembersList = webClient.get().uri(restUrl).retrieve().bodyToFlux(Member.class).collectList()
//				.block();
		
		List<Member> allMembersList = webClient.get().uri(restUrl).retrieve().bodyToFlux(Member.class).collect(Collectors.toList()).block();

		
		/* Just to Check
		 * List<String> membersByName = allMembersList.stream().filter(n ->
		 * n.getTm_name().equals(name))
		 * .map(Member::getM_name).collect(Collectors.toList());
		 */
		
		
		List<String> membersByName = allMembersList.stream().filter(n -> n.getTm_name().equals(name)).map(
				m -> "Teacher Name: " + name + " , Member name: " + m.getM_name() + "   ,  Member id:  " + m.getM_id())
				.collect(Collectors.toList());
		 
		
		
		
		
		
		

		return membersByName;
	}
	
	
	
	
}
