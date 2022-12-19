package com.myshop.shop.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.myshop.shop.entity.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface UserRepository extends JpaRepository<User,Long>, QuerydslPredicateExecutor<User> {


}
