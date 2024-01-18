package com.ssafy.hellospring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssafy.hellospring.repository.JdbcMemberRepository;
import com.ssafy.hellospring.repository.MemberRepository;
import com.ssafy.hellospring.service.MemberService;

@Configuration
public class SpringConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	public MemberService memberService(){
		return new MemberService(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository(){
		return new JdbcMemberRepository(dataSource);
	}
}
