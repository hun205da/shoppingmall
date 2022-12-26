package com.myshop.shop.repository;

import com.myshop.shop.entity.Faq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class FaqRepositoryTests {

    @Autowired
    private FaqRepository faqRepository;

    @Test
    public void insertDummies(){

        IntStream.rangeClosed(1,300).forEach(i -> {

            Faq faq = Faq.builder()
                    .title("Title..." +i)
                    .category("Category")
                    .text("Text...."+i)
                    .build();
            System.out.println(faqRepository.save(faq));
        });
    }

    @Test
    public void updateTest(){
        Optional<Faq> result =faqRepository.findById(300L);

        if(result.isPresent()){
            Faq faq = result.get();

            faq.changeTitle("Change Title...");
            faq.changeText("Change Text...");
            faq.changeCategory("Change Category");

            faqRepository.save(faq);
        }
    }
}
