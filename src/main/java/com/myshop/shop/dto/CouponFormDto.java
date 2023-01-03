package com.myshop.shop.dto;

import com.myshop.shop.constant.CouponStatus;
import com.myshop.shop.entity.Coupon;
import com.myshop.shop.entity.Member;
import org.modelmapper.ModelMapper;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CouponFormDto {

    private Long id;

    @NotBlank(message = "쿠폰명은 필수값 입니다.")
    private String Coupon;

    @NotNull(message = "할인가는 필수값입니다.")
    private Integer discount;

    @NotBlank(message = "쿠폰 상세는 필수값입니다.")
    private Integer stockNumber;

    @NotBlank(message = "쿠폰보유자는 필수값입니다.")
    private Member email;

    private CouponStatus couponStatus;

    private static ModelMapper modelMapper = new ModelMapper();

    public Coupon createCoupon() {return  modelMapper.map(this, Coupon.class);}

    public static CouponFormDto of(Coupon coupon) {return modelMapper.map(coupon, CouponFormDto.class);}

}
