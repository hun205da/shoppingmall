package com.myshop.shop.entity;

import com.myshop.shop.constant.CouponStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "coupon")
@Getter
@Setter
@ToString
public class Coupon extends BaseEntity {

    @Id
    @Column(name = "coupon_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //쿠폰 코드

    @Column(nullable = false)
    private String couponNm; //쿠폰명

    @Column(name = "discount_rate", nullable = false)
    private int discount; //남은 수량

    @Lob
    @Column(nullable = false)
    private String couponDetail; //쿠폰 상세 설명

    @Enumerated(EnumType.STRING)
    private CouponStatus couponStatus; //쿠폰상태

//    public void updateCoupon



}
