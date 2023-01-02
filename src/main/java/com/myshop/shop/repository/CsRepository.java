package com.myshop.shop.repository;

import com.myshop.shop.entity.Cs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CsRepository extends JpaRepository<Cs, Long>, QuerydslPredicateExecutor<Cs> {
    Cs findByMemberId(Long memberId);
}
