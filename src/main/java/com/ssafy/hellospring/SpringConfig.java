package com.ssafy.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssafy.hellospring.repository.MemberRepository;
import com.ssafy.hellospring.repository.MemoryMemberRepository;
import com.ssafy.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

	@Bean
	public MemberService memberService(){
		return new MemberService();
	}

	@Bean
	public MemberRepository memberRepository(){
		return  new MemoryMemberRepository();
	}
}
