package com.ssafy.hellospring.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.hellospring.domain.Member;
import com.ssafy.hellospring.repository.MemberRepository;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memberRepository;

	@Test
	void join() {
		//given
		Member member = new Member();
		member.setName("korea");

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
		member1.setName("Spring3");

		Member member2 = new Member();
		member2.setName("Spring3");

		//when
		memberService.join(member1);
		IllegalStateException  e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

		Assertions.assertThat(e.getMessage()).isEqualTo("존재하지 않은 회원입니다.");
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

