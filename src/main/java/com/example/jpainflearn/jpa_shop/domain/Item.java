package com.example.jpainflearn.jpa_shop.domain;

import javax.persistence.*;

@Entity
@Inheritance ( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn ( name = "DTYPE" )
public abstract class Item extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int price;
}
