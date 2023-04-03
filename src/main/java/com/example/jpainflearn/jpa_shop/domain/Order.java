package com.example.jpainflearn.jpa_shop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table ( name = "ORDERS" )
public class Order {

    @Id
    @GeneratedValue
    @Column ( name = "ORDER_ID" )
    private Long id;

    @OneToOne
    @JoinColumn ( name = "DELIVERY_ID" )
    private Delivery delivery;

    @ManyToOne
    @JoinColumn ( name = "MEMBER_ID" )
    private Member member;

    private LocalDateTime orderDateTime;

    @Enumerated ( EnumType.STRING )
    private OrderStatus status;
}
