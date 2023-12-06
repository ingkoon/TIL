package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import study.datajpa.entity.Member;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    List<Member> findByUserNameAndAgeGreaterThan(String userName, int age);

    @Query(name = "Member.findByUserName")
    List<Member> findByUserName(@Param("userName") String userName);


}
