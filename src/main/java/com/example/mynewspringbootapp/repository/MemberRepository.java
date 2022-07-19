package com.example.mynewspringbootapp.repository;

import com.example.mynewspringbootapp.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Integer> {

}
