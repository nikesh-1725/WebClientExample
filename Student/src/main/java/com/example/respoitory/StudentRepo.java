package com.example.respoitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Member;

public interface StudentRepo extends JpaRepository<Member, Integer>{

}
