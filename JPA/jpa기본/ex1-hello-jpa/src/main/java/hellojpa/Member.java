package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {
    /*
    십 몇억을 넘어가면 int는 다시 돈다.

     */
    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;


    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team Team;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public hellojpa.Team getTeam() {
        return Team;
    }

    public void setTeam(hellojpa.Team team) {
        Team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
