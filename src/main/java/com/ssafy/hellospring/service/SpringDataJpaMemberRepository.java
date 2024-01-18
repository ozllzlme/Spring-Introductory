package com.ssafy.hellospring.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.hellospring.domain.Member;
import com.ssafy.hellospring.repository.MemberRepository;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepository {
	@Override
	Optional<Member> findByName(String name);


}
