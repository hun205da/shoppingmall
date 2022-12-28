package com.myshop.shop.repository;

import com.myshop.shop.dto.UserDTO;
import com.myshop.shop.entity.Cs;
import com.myshop.shop.entity.User;
import com.myshop.shop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootTest
public class UserRepositoryTests {
  @Autowired
  private UserService userservice;
    @Test
    public void insertdummies(){

        IntStream.rangeClosed(1,300).forEach(i -> {

            UserDTO user_infodto = UserDTO.builder()
                    .userId(i+"Test")
                    .userPw(i+"Test")
                    .userName("user"+ i)
                    .userPhone("010-8898-4"+i)
                    .userEmail("user"+i+"@naver.com")
                    .emailCheck(1)
                    .build();
            userservice.userdata(user_infodto);
        });

    }
}
