package com.myshop.shop.repository;

import com.myshop.shop.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface FaqRepository extends JpaRepository<Faq, Long>, QuerydslPredicateExecutor<Faq>{
}
