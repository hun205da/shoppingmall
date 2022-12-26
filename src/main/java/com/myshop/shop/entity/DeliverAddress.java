package com.myshop.shop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "DeliverAddress")
@ToString(exclude = "User")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliverAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;
    @Column(length = 50 ,nullable = false)
    private String address1;
    @Column(length = 50 ,nullable = false)
    private String address2;
    @Column(length = 50 ,nullable = false)
    private String address3;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
