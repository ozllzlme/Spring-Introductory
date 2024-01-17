package com.ssafy.hellospring.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.ssafy.hellospring.domain.Member;

public class MemoryMemberRepositoryTest {

	MemberRepository repository = new MemoryMemberRepository();


	@Test
	public void  save(){
		Member member = new Member();
		member.setName("Spring");

		repository.save(member);

		Member result = repository.findById(member.getId()).get();
		//Assertions.assertEquals(member,result);
		Assertions.assertThat(member).isEqualTo(null);
		//System.out.println("result == member = " + (result == member));
	}

	@Test
	public void findByName(){
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		Member result = repository.findByName("spring1").get();

		Assertions.assertThat(result).isEqualTo(member1);
	}

	@Test
	public void findAll(){
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);

		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);

		List<Member> result = repository.findAll();

		Assertions.assertThat(result.size()).isEqualTo(2);
	}
}
