package com.myshop.shop.service;

import com.myshop.shop.dto.*;
import com.myshop.shop.entity.Coupon;
import com.myshop.shop.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;

    public Long saveCoupon(CouponFormDto couponFormDto) throws Exception{
        //쿠폰 등록
        Coupon coupon = couponFormDto.createCoupon();
        couponRepository.save(coupon);

        return coupon.getId();
    }

    @Transactional
    public CouponFormDto getCouponDtl(Long couponId){
        Coupon coupon = couponRepository.findById(couponId)
                .orElseThrow(EntityNotFoundException::new);
        CouponFormDto couponFormDto = CouponFormDto.of(coupon);
        return couponFormDto;
    }

    @Transactional
    public Page<Coupon> getAdminCouponPage(CouponSearchDto couponSearchDto, Pageable pageable){
        return couponRepository.getAdminCouponPage(couponSearchDto, pageable);
    }

    @Transactional
    public Page<MainCouponDto> getMainCouponPage(CouponSearchDto couponSearchDto, Pageable pageable){
        return couponRepository.getMainCouponPage(couponSearchDto, pageable);
    }


}
