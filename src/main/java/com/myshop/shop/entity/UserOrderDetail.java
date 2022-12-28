package com.myshop.shop.entity;

import lombok.*;

import javax.persistence.*;
@Entity
@Table(name = "Cart")
@ToString(exclude = {"product","userOrder"})
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserOrderDetail {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long orderDetailNumber;
        @Column(nullable = false)
        private int productCount;
        @Column(nullable = false)
        private int productPrice;
        @Column(nullable = false)
        private boolean orderDetailStatus;
    @Column(nullable = false)
    private boolean refundCheck;

        @ManyToOne(fetch = FetchType.LAZY)
        private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    private UserOrder userOrder;


}
