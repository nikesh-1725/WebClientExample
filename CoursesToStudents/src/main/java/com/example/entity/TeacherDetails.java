package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDetails {
	
	@Id
	private int t_id;
	private String t_name;
	private String t_schoolName;
	
}
