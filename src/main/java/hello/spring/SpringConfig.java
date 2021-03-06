package hello.spring;

import hello.spring.domain.Member;
import hello.spring.repository.JdbcMemberRepository;
import hello.spring.repository.MemberRepository;
import hello.spring.repository.MemoryMemberRepository;
import hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.swing.*;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());

    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
