package com.myshop.shop.repository;


import com.myshop.shop.repositoty.ShopRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.myshop.shop.entity.Shop;
import com.myshop.shop.entity.QShop;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest

public class ShopRepositoryTests {
    @Autowired
    private ShopRepository shopRepository;

    @Test
    public void insertDummies(){
        IntStream.rangeClosed(1,300).forEach(i -> {
            Shop shop = Shop.builder()
                    .title("Title..."+i)
                    .text("Text..."+i)
                    .user_id("user_id"+(i % 10))
                    .build();
            System.out.println(shopRepository.save(shop));
        });
    }


    @Test
    public void updateTest() {

        Optional<Shop> result = shopRepository.findById(300L); //존재하는 번호로 테스트

        if(result.isPresent()){

            Shop shop = result.get();

            shop.changeTitle("Changed Title....");
            shop.changeText("Changed Text...");

            shopRepository.save(shop);
        }
    }
}
