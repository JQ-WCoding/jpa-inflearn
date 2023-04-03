package com.example.jpainflearn.jpa_shop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {

    public Team() {
    }

    @Id
    @GeneratedValue
    @Column ( name = "TEAM_ID" )
    private Long id;

    private String name;

    // @Override
    // public String toString() {
    //     return "Team{" + "id=" + id + ", name='" + name + '\'' + ", members=" + members + '}';
    // }
}
