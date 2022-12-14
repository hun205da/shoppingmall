package com.myshop.shop.service;

import com.myshop.shop.dto.CsDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CSServiceTest {
    @Autowired
    private CsService service;

    @Test
    public void testRegister() {
        CsDTO csDTO = CsDTO.builder()
                .title("Sample Title..")
                .text("Sample Text")
                .user_id("user0")
                .build();

        System.out.println(service.register(csDTO));
    }
}
