package com.myshop.shop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CouponDto {
    private Long id;
    private String CouponNm;
    private Integer price;
    private String couponStatCd;
    private LocalDateTime regTime;
    private LocalDateTime updateTime;
}
