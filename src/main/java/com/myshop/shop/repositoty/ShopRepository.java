package com.myshop.shop.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myshop.shop.entity.Shop;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ShopRepository extends JpaRepository<Shop, Long>, QuerydslPredicateExecutor<Shop> {
}
