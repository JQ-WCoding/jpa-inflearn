package com.example.jpainflearn.hellojpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Locker {
    public Locker() {
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
