package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        /*
        2022.01.02 이인재
        EntityManagerFactory
        emf는 애플리케이션 로딩시점에서 단 하나만 생성하면된다.
        * */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 트랜잭션이 발생할 때마다 em을 만들어서 동작한다.
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 생성 후 실행
        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 이 코드는 좋은 코드가 아니다.

        //code
        try{
            /*
            * em으로 가져온 대상에 대해 JPA가 관리를 시작한다.
            * 변경 사항에 대해 transaction을 commit 하는 시점에서 파악후
            * 변경 사항에 대해 update를 수행한다.
            * */
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");

            // 영속 계층에 저장
            // em.persist(); 코드는 작성하지 않아도 된다.
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
