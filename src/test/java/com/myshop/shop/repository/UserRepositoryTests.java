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
                .userId("hkd2323231")
                .userPw("111")
                .userNickname("다다다")
                .userPhone("010-8898-4865")
                .build();
        UserDTO user_infodto1 = UserDTO.builder()
                .userId("hkddsdsd31231312")
                .userPw("111")
                .userNickname("다다다")
                .userPhone("010-8898-4865")
                .build();
        userservice.userdata(user_infodto);
        userservice.userdata(user_infodto1);
    }
}
