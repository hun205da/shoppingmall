package com.myshop.shop.entity;

import com.myshop.shop.constant.CouponStatus;
import com.myshop.shop.dto.CouponFormDto;
import com.myshop.shop.exception.OutOfStockException;
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

    @Column(name = "discount", nullable = false)
    private int discount; //할인가

    @Column(nullable = false)
    private int stockNumber;//수량

    @Enumerated(EnumType.STRING)
    private CouponStatus couponStatus; //쿠폰상태

    public void updateCoupon(CouponFormDto couponFormDto){
        this.couponNm = couponFormDto.getCouponNm();
        this.discount = couponFormDto.getDiscount();
        this.stockNumber = couponFormDto.getStockNumber();
        this.couponStatus = couponFormDto.getCouponStatus();
    }

    public void removeStock(int stockNumber){
        int restStock = this.stockNumber - stockNumber;
        if(restStock<0){
            throw new OutOfStockException("쿠폰의 재고가 부족 합니다. (현재 재고 수량: " + this.stockNumber +")");
        }
        this.stockNumber = restStock;
    }

    public void addStock(int stockNumber) { this.stockNumber += stockNumber;}



}
