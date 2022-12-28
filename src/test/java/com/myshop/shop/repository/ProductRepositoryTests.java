package com.myshop.shop.repository;

import com.myshop.shop.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void insertDummies() {
        IntStream.rangeClosed(1,200).forEach(i -> {
            Product product = Product.builder()
                    .productNumber(i)
                    .productName("상품명..." + i)
                    .productPrice(10000 + i)
                    .productStock(2 + i)
                    .build();
            System.out.println(productRepository.save(product));
        });
    }
}
