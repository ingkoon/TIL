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
            // 비영속 상태
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            //영속
            //하지만 이때까지도 DB에 저장되지 않는다.
            System.out.println("====== BEFORE ======");
            em.persist(member);
            System.out.println("====== AFTER ======");

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
