package com.myshop.shop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "NonuserOrderDetail")
@ToString(exclude = {"product","nonuserOrder"})
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NonuserOrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productNumber;
    @Column(nullable = false)
    private int productCount;
    @Column(nullable = false)
    private int productPrice;
    @Column(length = 50,nullable = false)
    private String orderDetailStatus;
    @Column(nullable = false)
    private boolean refundCheck;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    private NonuserOrder nonuserOrder;
}
