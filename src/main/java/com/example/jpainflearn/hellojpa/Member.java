package com.example.jpainflearn.hellojpa;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {

    public Member() {}

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    private Long id;
    private String name;

}
