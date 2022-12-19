package com.myshop.shop.repository;

import com.myshop.shop.dto.UserDTO;
import com.myshop.shop.entity.User;
import com.myshop.shop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootTest
public class UserRepositoryTests {
  @Autowired
  private UserService userservice;
    @Test
    public void insertdummies(){
        UserDTO user_infodto = UserDTO.builder()
                .user_id("hkd")
                .user_pw("111")
                .user_nickname("다다다")
                .user_phone("010-8898-4865")
                .build();
        UserDTO user_infodto1 = UserDTO.builder()
                .user_id("hkddsdsd")
                .user_pw("111")
                .user_nickname("다다다")
                .user_phone("010-8898-4865")
                .build();

        //이걸 쓰면적용이된다?

        userservice.userdata(user_infodto);
        userservice.userdata(user_infodto1);


    }
}
