package com.myshop.shop.security;

import com.myshop.shop.entity.User;
import com.myshop.shop.entity.UserRole;
import com.myshop.shop.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class UserTests {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertDummies() {

        //1 - 80까지는 USER만 지정
        //81- 90까지는 USER,MANAGER
        //91- 100까지는 USER,MANAGER,ADMIN

        IntStream.rangeClosed(1,100).forEach(i -> {
            User user = User.builder()
                    .userId("user"+i)
                    .userName("username"+i)
                    .fromSocial(false)
                    .roleSet(new HashSet<UserRole>())
                    .userPw(passwordEncoder.encode("1111") )
                    .build();

            //default role
            user.addMemberRole(UserRole.USER);

            if(i > 80){
                user.addMemberRole(UserRole.MANAGER);
            }

            if(i > 90){
                user.addMemberRole(UserRole.ADMIN);
            }

            repository.save(user);

        });
    }
        @Test
        public void testRead() {

            Optional<User> result = repository.findById("user4");

            User user = result.get();

            System.out.println(user);

        }



}
