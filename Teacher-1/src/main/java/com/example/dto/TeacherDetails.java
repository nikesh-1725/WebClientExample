package com.example.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="teacherDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDetails {
	
	@Id
	private int t_id;
	private String t_name;
	private String t_schoolName;
	//private String t_course;
}
