package com.example.entity;

import jakarta.persistence.Entity;
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
	
	int id;
	String name;
	String department;
}
