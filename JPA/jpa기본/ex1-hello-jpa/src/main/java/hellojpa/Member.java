package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {
    /*
    십 몇억을 넘어가면 int는 다시 돈다.

     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    /*
    기본적으로 ORDINAL 타입이다.
    하지만 권장하지 않는다.
    enum클래스의 요소들의 순서가 바뀌면
    바뀐대로 적용되기 때문에
    */
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob // 큰 타입의 문자열을 넣고 싶은 경우에 사용하는 어노테이션
    private String description;

    public Member() {
    }
}
