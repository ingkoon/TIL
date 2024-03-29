package study.datajpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.dto.MemberDto;
import study.datajpa.entity.Member;
import study.datajpa.entity.Team;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
public class  MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    MemberQueryRepository memberQueryRepository;

    @PersistenceContext
    EntityManager em;
    @Test
    public void basicCRUD(){
        Member member1 = new Member("member1");
        Member member2 = new Member("member2");

        memberRepository.save(member1);
        memberRepository.save(member2);

        //단건 조회 검증
        Member findMember1 = memberRepository.findById(member1.getId()).get();
        Member findMember2 = memberRepository.findById(member2.getId()).get();
        assertThat(findMember1).isEqualTo(member1);
        assertThat(findMember2).isEqualTo(member2);

        //리스트 조회 검증
        List<Member> all = memberRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        //카운트 검증
        long count = memberRepository.count();
        assertThat(count).isEqualTo(2);

        //삭제 검증
        memberRepository.delete(member1);
        memberRepository.delete(member2);

        long deleteCount = memberRepository.count();
        assertThat(deleteCount).isEqualTo(0);
    }

    @Test
    public void findByUsernameAndAgeGreateThen(){
        Member m1 = new Member("AAA", 10);
        Member m2 = new Member("AAA", 20);

        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> result = memberRepository.findByUserNameAndAgeGreaterThan("AAA", 15);

        assertThat(result.get(0).getUserName()).isEqualTo("AAA");
        assertThat(result.get(0).getAge()).isEqualTo(20);
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void testNamedQuery(){
        Member m1 = new Member("AAA", 10);
        Member m2 = new Member("AAA", 20);

        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> result = memberRepository.findByUserName("AAA");
        Member findMember = result.get(0);

        assertThat(findMember).isEqualTo(m1);
    }

    @Test
    public void testQuery(){
        Member m1 = new Member("AAA", 10);
        Member m2 = new Member("AAA", 20);

        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> result = memberRepository.findUser("AAA", 10);
        Member findMember = result.get(0);
        assertThat(findMember).isEqualTo(m1);
    }

    @Test
    public void findUserNameList(){
        Member m1 = new Member("AAA", 10);
        Member m2 = new Member("BBB", 20);

        memberRepository.save(m1);
        memberRepository.save(m2);

        List<String> result = memberRepository.findUserNameList();
        for (String s : result) {
            System.out.println(s);
        }
    }

    @Test
    public void findMemberDto(){
        Team team = new Team("teamA");
        teamRepository.save(team);

        Member m1 = new Member("AAA", 10);
        m1.setTeam(team);
        memberRepository.save(m1);

        List<MemberDto> memberDto = memberRepository.findMemberDto();
        for (MemberDto dto : memberDto) {
            System.out.println("dto = " + dto);
        }
    }

    @Test
    public void findByNames(){
        Member m1 = new Member("AAA", 10);
        Member m2 = new Member("BBB", 20);

        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> members = memberRepository.findByNames(Arrays.asList("AAA", "BBB"));

        for (Member member : members) {
            System.out.println("member = " + member);
        }
    }

    @Test
    public void paging(){
        // given
        for (int i = 1; i <= 10; i++) {
            memberRepository.save(new Member("Member"+i, 10));
        }
        int age = 10;
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "userName"));
        //when
        Page<Member> page = memberRepository.findByAge(age, pageRequest);

        /**
         * member엔티티 대신 dto를 반환한다.
         */
        Page<MemberDto> dtos = page.map(member -> new MemberDto(member.getId(), member.getUserName(), null));

        //then
        List<Member> members = page.getContent();
        for (Member member : members) {
            System.out.println(member);
        }
        long totalElements = page.getTotalElements();
        assertThat(page.getSize()).isEqualTo(3);
        assertThat(totalElements).isEqualTo(10);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.isFirst()).isEqualTo(true);
        assertThat(page.hasNext()).isEqualTo(true);

        System.out.println("totalElements = " + totalElements);
    }

    @Test
    public void Slicing(){
        // given
        for (int i = 1; i <= 10; i++) {
            memberRepository.save(new Member("Member"+i, 10));
        }
        int age = 10;
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "userName"));
        //when
        Slice<Member> slice = memberRepository.findSliceByAge(age, pageRequest);

        //then
        List<Member> members = slice.getContent();
        for (Member member : members) {
            System.out.println(member);
        }
        assertThat(slice.getSize()).isEqualTo(3);
        assertThat(slice.getNumber()).isEqualTo(0);
        assertThat(slice.isFirst()).isEqualTo(true);
        assertThat(slice.hasNext()).isEqualTo(true);
    }

    @Test
    public void bulkUpdate(){
        // given
        memberRepository.save(new Member("Member1", 10));
        memberRepository.save(new Member("Member2", 19));
        memberRepository.save(new Member("Member3", 20));
        memberRepository.save(new Member("Member4", 21));
        memberRepository.save(new Member("Member5", 40));

        //when
        int resultCount = memberRepository.bulkAgePlus(20);

//        em.clear();

        List<Member> result = memberRepository.findByUserName("Member5");
        Member member5 = result.get(0);

        System.out.println(member5.getAge()); // 40이 조회 될 것이다.(영속성 컨텍스트때문에)

        //then
        assertThat(resultCount).isEqualTo(3);
    }

    @Test
    public void findMemeberLazy(){
        //given
        //member1 -> teamA
        //member2 -> teamB

        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member1", 10, teamB);
        memberRepository.save(member1);
        memberRepository.save(member2);

        em.flush();
        em.clear();

        //when
        List<Member> members = memberRepository.findEntityGraphByUserName("member1");
        for (Member member : members) {
            System.out.println("member = " + member.getUserName());
            System.out.println("team.getClass() = " + member.getTeam().getClass());
            System.out.println("member.getTeam().getName() = " + member.getTeam().getName());
        }
        
        //then
    }

    @Test
    public void queryHint(){
        //given
        Member member1 = new Member("member1", 10);
        memberRepository.save(member1);
        em.flush(); // 결과를 db에 동기화
        em.clear();

        //when
        Member findMember = memberRepository.findReadOnlyByUserName("member1"); // readonly는 변경감지를 적용하지 않는다.
        findMember.setUserName("member2");

        em.flush(); // 변경된 상태를 감지 후 DB 상태를 업데이트시킨다.
        //then
    }

    @Test
    public void lock(){
        //given
        Member member1 = new Member("member1", 10);
        memberRepository.save(member1);
        em.flush(); // 결과를 db에 동기화
        em.clear();

        //when
        List<Member> list= memberRepository.findLockByUserName("member1");
        //then
    }

    @Test
    public void callCustom(){
        List<Member> result = memberRepository.findMemberCustom();
    }

}
