package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table(name = "USER") 테이블 매핑하는 과정에서 사용한다. 기본적으로 엔티티 이름을 사용한다.
public class Member {
    @Id
    private Long id;
    private String name;

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
