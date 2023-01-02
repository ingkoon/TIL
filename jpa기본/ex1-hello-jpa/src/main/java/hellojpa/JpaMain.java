package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        /*
        2022.01.02 이인재
        EntityManagerFactory
        EntityManagerFactory는 애플리케이션 로딩시점(웹서버가 올라가는 시점)에서
        단 하나만 생성하면된다.
        * */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 트랜잭션이 발생할 때마다 em을 만들어서 동작한다.
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 생성 후 실행
        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 이 코드는 좋은 코드가 아니다.

        //code
        try{
            // 대상의 테이블이 아닌 대상의 객체(Entity)를 가져온다.
            // 이렇게 작성시 DB에 맞는 문법을 통해 구현해준다.
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(0)
                    .setMaxResults(9)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.getName() = " + member.getName());
            }
            tx.commit();
        } catch (Exception e){
            // 문제 발생시 rollback
            tx.rollback();
        } finally {
            // em이 내부적으로 데이터베이스 커넥션을 가져가기 때문에 사용 후 종료해주어야 한다.
            em.close();
        }

        //emf 종료
        emf.close();

    }
}
