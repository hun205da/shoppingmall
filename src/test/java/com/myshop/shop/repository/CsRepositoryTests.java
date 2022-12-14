package com.myshop.shop.repository;


import com.myshop.shop.entity.Cs;
import com.myshop.shop.repositoty.CsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest

public class CsRepositoryTests {
    @Autowired
    private CsRepository shopRepository;

    @Test
    public void insertDummies(){
        IntStream.rangeClosed(1,300).forEach(i -> {
            Cs cs = com.myshop.shop.entity.Cs.builder()
                    .title("Title..."+i)
                    .text("Text..."+i)
                    .user_id("user_id"+(i % 10))
                    .build();
            System.out.println(shopRepository.save(cs));
        });
    }


    @Test
    public void updateTest() {

        Optional<Cs> result = shopRepository.findById(300L); //존재하는 번호로 테스트

        if(result.isPresent()){

            Cs cs = result.get();

            cs.changeTitle("Changed Title....");
            cs.changeText("Changed Text...");

            shopRepository.save(cs);
        }
    }
}
