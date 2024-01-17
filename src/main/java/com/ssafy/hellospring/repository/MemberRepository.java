package com.ssafy.hellospring.repository;

import java.util.Optional;
import java.util.List;

import com.ssafy.hellospring.domain.Member;

public class MemberRepository {
	Member save(Member member);
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();

}
