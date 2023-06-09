package com.example.jpainflearn.jpa_shop.domain;

import com.example.jpainflearn.hellojpa.Locker;
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

    @ManyToOne ( fetch = FetchType.LAZY ) // 지연로딩, Eager 즉시로딩
    @JoinColumn ( name = "TEAM_ID" )
    private Team team;

    @OneToOne
    @JoinColumn ( name = "LOCKER_ID" )
    private Locker locker;

    // @Override // 양방향 매핑 시, 무한루프 조심
    // public String toString() {
    //     return "Member{" + "id=" + id + ", name='" + name + '\'' + ", team=" + team + '}';
    // }
}
