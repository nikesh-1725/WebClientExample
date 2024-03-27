package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Course")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Course {
	
	@Id
	int c_id;
	String c_name;
	String tc_name;
	}
