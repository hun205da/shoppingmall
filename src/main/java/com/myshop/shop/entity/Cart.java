package com.myshop.shop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Cart")
@ToString(exclude = "Product")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartNumber;
    @Column(nullable = false)
    private boolean cartValue;
    @Column(nullable = false)
    private int productCount;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
