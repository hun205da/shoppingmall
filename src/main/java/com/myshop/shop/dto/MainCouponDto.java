package com.myshop.shop.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MainCouponDto {
    private Long id;

    private String couponNm;

    private Integer discount;

    @QueryProjection
    public MainCouponDto(Long id, String couponNm, Integer discount){
        this.id = id;
        this.couponNm = couponNm;
        this.discount = discount;
    }
}
