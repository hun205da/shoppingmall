package com.myshop.shop.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Coupon extends BaseEntity {

    @Id
    @Column(name = "conpon_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //쿠폰 코드

    @Column(nullable = false)
    private String couponNm;

    @Column(name = "discount_rate", nullable = false)
    private int discountRate;


}
