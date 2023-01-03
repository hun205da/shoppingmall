package com.myshop.shop.dto;

import com.myshop.shop.constant.CouponStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CouponSearchDto {
    private String searchDateType;
    private CouponStatus searchStatus;
    private String searchBy;
    private String searchQuery = "";
}
