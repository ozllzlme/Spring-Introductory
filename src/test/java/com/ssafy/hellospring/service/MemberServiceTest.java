package com.ssafy.hellospring.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ssafy.hellospring.domain.Member;
import com.ssafy.hellospring.repository.MemoryMemberRepository;

class MemberServiceTest {

	MemberService memberService = new MemberService();
	MemoryMemberRepository memberRepository = new MemoryMemberRepository();

	@BeforeEach
	public void beforeEach(){
		memberRepository = new MemoryMemberRepository();
		memberService = new MemberService(memberRepository);
	}

	@AfterEach
	public void afterEach(){
		memberRepository.clearStore();
	}

	@Test
	void join() {
		//given
		Member member = new Member();
		member.setName("hello");

		//when
		Long saveId = memberService.join(member);

		//then
		Member findMember = memberService.findOne(saveId).get();
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
	}

	@Test
	public void 중복_회원_예외(){
		//given
		Member member1 = new Member();
		member1.setName("Spring");

		Member member2 = new Member();
		member2.setName("Spring");

		//when
		memberService.join(member1);
		IllegalStateException  e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

		Assertions.assertThat(e.getMessage()).isEqualTo("존재하지 않은 회원입니다.");

		// try {
		// 	memberService.join(member2);
		// 	fail();
		// }catch (IllegalStateException e){
		// 	Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		// }

		//then
	}

	@Test
	void findMembers() {
		//given

		//when

		//then
	}

	@Test
	void findOne() {
	}
}