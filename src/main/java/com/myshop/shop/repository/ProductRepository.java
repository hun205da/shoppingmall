package com.myshop.shop.repository;

import com.myshop.shop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, QuerydslPredicateExecutor<Product> {
    @Query("select p, pi,  count(r) from Product p " +
            "left outer join ProductImage pi on pi.product = p " +
            "left outer join ProductReply r on r.product = p group by p ")
    Page<Object[]> getListPage(Pageable pageable);


    @Query("select p, pi, count(r)" +
            " from Product p left outer join ProductImage pi on pi.product = p " +
            " left outer join ProductReply r on r.product = p "+
            " where p.productNumber = :productNumber group by pi")
    List<Object[]> getMovieWithAll(Long productNumber);
}
