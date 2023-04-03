package com.example.jpainflearn.jpa_shop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Items {

    @Id
    @GeneratedValue
    @Column ( name = "ITEM_ID" )
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    @ManyToMany ( mappedBy = "items" )
    private List<Category> categories = new ArrayList<>();
}
