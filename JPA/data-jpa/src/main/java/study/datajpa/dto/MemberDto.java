package study.datajpa.dto;

import lombok.Data;
import study.datajpa.entity.Member;

@Data // 실무에서 사용하면 안된다.
public class MemberDto {
    private Long id;
    private String userName;
    private String name ;

    public MemberDto(Long id, String userName, String name) {
        this.id = id;
        this.userName = userName;
        this.name = name;
    }

    public MemberDto(Member member) {
        this.id = member.getId();
        this.userName = member.getUserName();
    }
}
