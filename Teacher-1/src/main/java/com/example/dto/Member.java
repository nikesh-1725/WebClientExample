package com.example.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Member")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	
	@Id
	int m_id;
	String m_name;
	//String m_course;
	String tm_name;
}
