package com.myshop.shop.repository;

import com.myshop.shop.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CouponRepository extends JpaRepository<Coupon, Long>, QuerydslPredicateExecutor<Coupon> {
}