package com.ssafy.hellospring.service;

import java.util.List;
import java.util.Optional;

import com.ssafy.hellospring.domain.Member;
import com.ssafy.hellospring.repository.MemberRepository;
import com.ssafy.hellospring.repository.MemoryMemberRepository;

public class MemberService {
	private final MemberRepository memberRepository = new MemoryMemberRepository();

	/**
	 * 회원 가입
	 */
	public Long join(Member member){
		validateDuplicateMember(member);//중복회원검증
		memberRepository.save(member);
		return member.getId();
	}

	private void validateDuplicateMember(Member member) {
		Optional<Member> result = memberRepository.findByName(member.getName());
		result.ifPresent(m -> {
			throw  new IllegalStateException("이미 존재하는 회원입니다.");
		});
	}

	/**
	 *전체 회원 조회
	 */

	public List<Member> findMembers(){
		return memberRepository.findAll();
	}

	public Optional<Member> findOne(Long memberId)
	{
		return memberRepository.findById(memberId);
	}}
