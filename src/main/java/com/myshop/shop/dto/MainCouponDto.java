package com.myshop.shop.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MainCouponDto {
    private Long id;

    private String couponNm;

    private String couponDetail;

    private Integer discount;

    @QueryProjection
    public MainCouponDto(Long id, String couponNm, String couponDetail, Integer discount){
        this.id = id;
        this.couponNm = couponNm;
        this.couponDetail = couponDetail;
        this.discount = discount;
    }
}
