package com.myshop.shop.repository;

import com.myshop.shop.dto.CouponSearchDto;
import com.myshop.shop.entity.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CouponRepositoryCustom {
    Page<Coupon> getAdminCouponPage(CouponSearchDto couponSearchDto, Pageable pageable);
}
