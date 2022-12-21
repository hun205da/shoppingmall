package com.myshop.shop.security;

import com.myshop.shop.entity.User;
import com.myshop.shop.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.IntStream;

@SpringBootTest
public class UserTests {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Test
//    public void insertDummies() {
//
//        //1 - 80까지는 USER만 지정
//        //81- 90까지는 USER,MANAGER
//        //91- 100까지는 USER,MANAGER,ADMIN
//
//        IntStream.rangeClosed(1,100).forEach(i -> {
//            User user = user.builder()
//                    .userId("사용자"+i)
//                    .fromSocial(false)
//                    .userGrade(new HashSet<UserRole>())
//                    .userPw(  passwordEncoder.encode("1111") )
//                    .build();
//
//            //default role
//            clubMember.addMemberRole(ClubMemberRole.USER);
//
//            if(i > 80){
//                clubMember.addMemberRole(ClubMemberRole.MANAGER);
//            }
//
//            if(i > 90){
//                clubMember.addMemberRole(ClubMemberRole.ADMIN);
//            }
//
//            repository.save(clubMember);
//
//        });
//
//    }
}
