package com.example.jpainflearn.jpa_shop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column ( name = "MEMBER_ID" )
    private Long id;

    @Column ( name = "USERNAME" )
    private String name;

    @ManyToOne
    @JoinColumn ( name = "TEAM_ID" )
    private Team team;

    // @Override // 양방향 매핑 시, 무한루프 조심
    // public String toString() {
    //     return "Member{" + "id=" + id + ", name='" + name + '\'' + ", team=" + team + '}';
    // }
}
