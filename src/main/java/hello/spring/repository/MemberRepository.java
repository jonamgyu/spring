package hello.spring.repository;

import hello.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByid(Long Id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
