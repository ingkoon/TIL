package study.datajpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import study.datajpa.entity.Member;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberJpaRepository {

    @PersistenceContext
    private EntityManager em;

    public Member save(Member member){
        em.persist(member);
        return member;
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }

    public void delete(Member member){
        em.remove(member);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public Optional<Member> findById(Long id){
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    public long count(){
        return em.createQuery("select count(m) from Member m", Long.class)
                .getSingleResult();
    }

    public List<Member> findByUserNameAndAgeGreaterThen(String userName, int age){
        return em.createQuery("select m from Member m where m.userName = :userName and m.age >:age", Member.class)
                .setParameter("userName", userName)
                .setParameter("age", age)
                .getResultList();
    }

    public List<Member> findByUserName(String userName){
        return em.createNamedQuery("Member.findByUserName", Member.class)
                .setParameter("userName", userName)
                .getResultList();
    }

    public List <Member> findByPage(int age, int offset, int limit){
        return em.createQuery("select m from Member m where m.age = :age " +
                "order by m.userName desc", Member.class)
                .setParameter("age", age)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }

    public long totalCount(int age){
        return em.createQuery("select count(m) from Member m where m.age = :age ", Long.class)
                .setParameter("age", age)
                .getSingleResult();
    }


    public int bulkAgePlus(int age){
        return em.createQuery("update Member m set m.age = m.age + 1" +
                        "where m.age >= :age")
                .setParameter("age", age)
                .executeUpdate();
    }
}
