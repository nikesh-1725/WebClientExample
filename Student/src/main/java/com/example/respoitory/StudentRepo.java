package com.example.respoitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Member;

@Repository
public interface StudentRepo extends JpaRepository<Member, Integer>{

}
