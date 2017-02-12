package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shop.domain.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByName(String name);
}
