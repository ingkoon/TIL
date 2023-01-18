# JPA 학습



<details>
<summary>1. SQL 중심적인 개발의 문제점</summary>

## 1. SQL 중심적인 개발의 문제점

---

애플리케이션을 개발할 때 객체지향 언어로 작성을 한다.

데이터베이스 세계는 관계형 DB를 많이 사용한다.

지금 시대는 객체를 관계형 DB에 관리한다.

이렇게 하려면 관리를 위한 SQL을 사용해야한다.

여기서 발생하는 문제점은

## 반복되는/지루한 코드(CRUD)

자바 객체를 SQL로 SQL을 자바 객체로 바꾸는 과정이 반복된다.

```java
public class Member{
	private Stirng memberId;
	private String name;
	...
}
```

```java
INSERT INTO MEMBER(MEMBER_ID, NAME, TEL) VALUES ...
SELECT MEMBER_ID, NAME, TEL FROM MEMBER M
UPDATE MEMBER SET ...
```

SQL에 의존적인 개발을 피하기가 어렵다.

여기서 발생하는 것이

## 패러다임의 불일치

## 현실적인 대안은 관계형 데이터베이스

객체를 관계형 데이터베이스에 저장

대표적인 예시로 MyBatis가 있는데

> 객체 → SQL변환 → SQL+DB
> 

개발자 = SQL 매퍼

### 객체와 관계형 데이터베이스의 차이

1. 상속
2. 연관관계
3. 데이터 타입
4. 데이터 식별 방법

상속 관계는 데이터 베이스 테이블에 저장할 수 없다.

하지만 비슷하게 볼 수 있는 방법이 있다.

부모같은 테이블 + 자식같은 테이블을 만들어 필요시 join을 통해 연결한다

TABLE 슈퍼타입 서브타입 관계

Album 관계

---

1. 객체 분해
2. Insert 부모
3. insert 자식

두개를 작성해야한다는 단점이 있다.

조회시는 

각각의 테이블에 따른 join sql 작성이 필요하다.

각각의 객체 생성

복잡해 진다.

따라서 DB에 저장할 객체에 대해서는 상속을 사용하지 않는다.

자식이 늘어날 수록 join해야하는 쿼리도 늘어나며 이를 해야하는게 개발자의 몫이 된다.

## 이를 자바 collection에 저장한다면?

```java
list.add(album);

Album album = list.get(albumId);

// 부모타입으로 조회 후 다형성 활용
Item item = list.get(albumId);
```

## 연관관계

- 객체는 참조를 사용: member.getTeam()
- 테이블은 외래 키를 사용: JOIN ON M.TEAM_ID = T.TEAM_ID

![Untitled](/img/1-1.png)

## 객체를 테이블에 맞추어 모델링이 수행된다.

```java
class Member{
	String id;
	Long teamId;
	String username;
}

class Team{
	Long id;
	String name;
}
```

위와 같이 만들 경우 객체다운 모델링이 아닐 수 있다.

```java
class Member{
	String id;
	Team team;
	String username;
}

class Team{
	Long id;
	String name;
}
```

위와 같은것이 객체다운 모델링이지만 이는 

데이터베이스에 SQL 쿼리를 날릴 때 조금 어려워진다는 단점이 있다.

조회할 때도 쉽지가 않다.

연관관계째로 가져오고 싶다면

```java
Select M.*, T.*
	FROM MEMBER M
	JOIN TEAM T ON M.TEAM_ID = T.TEAM_ID

public Member find(String member_id){
	...
}
```

이런 객체 모델링을 자바 컬렉션에 관리를 한다면?

list.add(member);

Member member = list.get(memberId);

Team team = member.getTeam();

결국 RDB와 객체지향 프로그래밍간의 관점, 패러다임의 차이에 의해 변환과정을 어느정도 해소 시킬 수 있는 것이 JPA인듯?

객체는 자유롭게 객체 크래프를 탐색할 수 있어야 한다.

엔티티 신뢰의 문제 → 계층이 성립이 되어야 한다.

dao를 통해 객체를 가져왔을 때 객체 내의 정보를 조회할 수 있는지 확신할 수 없다.

(보통 이럴때 내부를 까보는 경향이 없지않아 있다)

모든 객체를 미리 로딩할 수 있을까?

상황에 따라 동일한 조회 메서드를 여러번 생성

<aside>
☕ 진정한의미의 계층 분할이 어렵다.

</aside>

결국 말하고자 하는 것은

객체지향적으로 설계를 한다고 할 수록 매핑작업만 늘어난다.

</details>

<details>
<summary> JPA 소개 </summary>

# JPA?

![Untitled](/img/2-1.png)

# ORM?

객체 관계 매핑

객체는 객체대로 설계

관계형 데이터베이스는 관계형 데이터베이스대로 설계

ORM 프레임워크가 중간에서 매핑

대중적인 언어에는 대부분 ORM 기술이 존재

# JPA 동작 - 저장

![Untitled](/img/2-2.png)

회원 생성 동작을 수행한다고 한다면 JPA가 알아서 회원 정보를 생성하고 insert쿼리를 생성한다.

# JPA 동작 - 조회

![Untitled](/img/2-3.png)

# JPA는 표준 명세

---

- 인터페이스의 모음
- JPA2.1 표준 명세를 구현한 3가지 구현체
- 하이버네이트, EclipseLink, DataNucleus

![Untitled](/img/2-4.png)

대부분은 hibernate를 많이 사용한다.

대부분의 ORM기능을 포함,

스토어드 프로시저, 컨버터, 엔티티 그래프 기능 추가

사용해야하는 이유

SQL중심적인 개발에서 객체 중심으로 개발

생산성

- 저장
    - jpa.persist(member)
    - 이렇게 호출 시 collections에서 조회한 것 처럼 불러낼 수 있다.
- 조회
    - Member member = jpa.find(memberId);
- 수정
    - member.setName(”변경할 이름”)
- 삭제
    - jpa.remove(member)

유지보수

- 기존의 경우 필드 변경시 모든 SQL을 수정해야한다.
- JPA의 경우 필드만 추가하면 된다. JPA가 쿼리를 생성해준다

패러다임의 불일치 해결

- 상속
    - 슈퍼타입, 서브타입 생성할 필요가 없다.
    - 개발자는 코드만 작성
    - JPA가 부모, 자식테이블에 대한 쿼리를 작성해준다.
- 연관관계
    - 연관관계를 저장
    
    ```java
    member.setTeam(team);
    jpa.persist(member);
    ```
    
- 객체 관계 그래프 탐색
    
    ```java
    Member member = jpa.find(Member.class, memberId);
    Team team = member.getTeam();
    ```
    
- 신뢰할 수 있는 엔티티, 계층
    
    ```java
    class MemberService{
    	public void process(){
    		Member member = memberDAO.find(memberId);
    		member.getTeam();
    		member.getOrder().getDelivery();
    	}
    }
    ```
    
- 동일한 트랜잭션에서 조회한 엔티티는 같음을 보장

성능 최적화 기능

- 1차 캐시와 동일성 보장
    - 같은 트랜잭션 안에는 같은 엔티티를 반환 - 조회 성능 향상
    - DB Isolation level이 Read Commit이어도 애플리케이션에서 Repeatable Read 보장
    
    ```java
    String memberId = "100";
    Member m1 = jpa.find(Member.class, memberId); //SQL 실행
    Member m2 = jpa.find(Member.class, memberId); // 1차캐시에서 값 가져온다.
    
    System.out.println(m1==m2); // true가 발생한다.
    ```
    
- 트랜잭션을 지원하는 쓰기 지연
    - 트랜잭션을 커밋할 때까지 INSERT SQL을 모음
    - JDBC BATCH SQL 기능을 사용해서 한번에 SQL 전송
    
    ```java
    transaction.begin(); // 트랜잭션 시작
    
    em.persist(memberA);
    em.persist(memberB);
    em.persist(memberC);
    // 여기까지 INSERT SQL을 데이터베이스에 보내지 않는다.
    
    // 커밋하는 순간 데이터베이스에 INSERT SQL을 모아서 보낸다.
    transaction.commit();
    ```
    
- 지연로딩과 즉시 로딩
    - 지연로딩
        - 객체가 실제 사용될 때 로딩
        
        ```java
        Member member = memberDAO.find(memberID); // SELECT * FROM MEMBER
        Team team = member.getTeam();
        
        // 이 때 프록시를 초기화 하면서 
        String teamName = team.getName(); // SELECT  * FROM TEAM;
        ```
        
    - 즉시로딩
        - JOIN SQL로 한번에 연관된 객체까지 미리 조회
        
        ```java
        Member member = memberDAO.find(memberID); // SELECT M.*, T.* FROM MEMBER JOIN TEAM ...
        Team team = member.getTeam();
        String teamName = team.getName(); 
        ```
        
    - 기본적으로 지연로딩을 적용시키고 성능적으로 요구될 시 즉시로딩을 적용한다.

데이터 접근 추상화와 벤더 독립성

표준

<aside>
☕ ORM은 객체와 RDB 두 기둥위에 있는 기술

</aside>

</details>

<details>
<summary>영속성 컨텍스트</summary>

# 영속성 컨텍스트

---

JPA에서 중요한 두가지 키워드는 다음과 같다.

# 1. 객체와 관계형데이터베이스 매핑

# 2. 영속성 컨텍스트

![스크린샷 2023-01-03 오후 9.20.53.png](img/3-1.png)

- JPA를 이해하는데 가장 중요한 용어
- 엔티티를 영구 저장하는 환경

```java
EntityManager.persist(entity);
```

사실 해당 코드를 실행할 경우 DB에 실제로 저장하는 것이 아니라 객체를 영속화한다.

## 엔티티 매니저? 영속성 컨텍스트?

- 영속성 컨텍스트는 논리적인 개념
- 눈에 보이지 않는다.
- 엔티티 매니저를 통해서 영속성 컨텍스트에 접근

엔티티 매니저를 생성하면 그 안에 영속성 컨텍스트가 1:1로 매핑이 된다.

# 엔티티의 생명주기

![Untitled](img/3-2.png)

### 비영속(new/transient)

영속성 컨텍스트와 전혀 관계가 없는 새로운 상태

### 영속(managed)

영속성 컨텍스트에 관리되는 상태

### 준영속(detached)

영속성 컨텍스트에 저장되었다가 분리된 상태

### 삭제(removed)

삭제된 상태

## 비영속

비영속 상태의 객체를 생성한다.

```java
Member member = new Member90;
member.setId("member1");
member.setUsername("name");
//여기 까지 간다면 비영속 상태이다

EntityManager em = emf.createEntityManager();
em.getTransaction().begin();

// 해당 코드를 수행 시 영속상태가 된다.
// 하지만 이때까지도 DB에 접근하지 않는다.
em.persist(member);
```

## 준영속

영속상태의 객체를 detach를 통해 영속상태에서 분리시킨다.

# 영속성 컨텍스트의 이점

- 1차 캐시
- 동일성 보장
- 트랜잭션을 지원하는 쓰기지연
- 변경 감지
- 지연 로딩

## 1차 캐시

영속성 컨텍스트를 생성하면 PK로 지정한 값과 엔티티가 key-value쌍으로 묶여서 쓰인다.

```java
// 엔티티를 생성한 상태 (비영속)
Member member = new Member();
member.setId("memberId");
member.setUsername("회원1");

//엔티티를 영속
em.persist(member);
```

이후 조회를 수행 할 경우 가장 먼저 1차캐시에서 해당 객체를 조회하며 

이는 영속계층에 직접적으로 접근하지 않기 때문에 우수한 성능 장점을 갖고 있다.

DB에서 조회한 값도 반환과 동시에 1차캐시에 저장한다.

하지만 데이터 트랜잭션이 끝날 경우 영속성 컨텍스트를 담은 엔티티 매니저를 삭제한다.

따라서 1차캐시도 함께 삭제된다.

성능적 이점을 찾기는 어렵다고 볼 수 있다.(비즈니스로직이 복잡한 경우 제외)

## 영속 엔티티의 동일성 보장

```java
Member findMember = em.find(Member.class, 101L);
Member findMember2 = em.find(Member.class, 101L);

System.out.println(a == b); //동일성 비교 = true;
```

위와 같은 현상이 가능한 이유는 1차캐시로 반복 가능한 읽기(REPEATABLE READ) 등급의 

트랜잭션 격리 수준을 데이터베이스가 아닌 애플리케이션 차원에서 제공

같은 트랜잭션안에서 실행되는 문장은 true가 발생할 수 있다.

## 엔티티 등록

트랜잭션을 지원하는 쓰기 지연

```java
EntityManager em = emf.createEntityManager();
EntityTransaction transaction = em.getTransaction();//엔티티 매니저는 데이터 변경시 트랜잭션을 시작해야 한다.
transaction.begin(); // [트랜잭션] 시작

em.persist(memberA);
em.persist(memberB);//여기까지 INSERT SQL을 데이터베이스에 보내지 않는다.

//커밋하는 순간 데이터베이스에 INSERT SQL을 보낸다.
transaction.commit(); // [트랜잭션] 커밋
```

1차캐시 내부에는 쓰기지연 저장소가 존재한다.

insert를 실행 시 1차캐시에 엔티티가 저장된다. 이때 쓰기지연 저장소에 insert쿼리를 적재한다.

b를 생성해서 넣을 경우 b도 1차캐시에 저장된다. 이때도 쓰기지연 저장소에 SQL이 적재된다.

트랜잭션을 커밋하는 시점에

쓰기지연 저장소에 있던 쿼리가 flush되어 DB에 날아가며 Commit이 수행된다.

</details>