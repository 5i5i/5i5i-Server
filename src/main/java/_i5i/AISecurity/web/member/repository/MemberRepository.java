package _i5i.AISecurity.web.member.repository;

import _i5i.AISecurity.web.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
}
