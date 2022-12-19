package com.myshop.shop.service;

import com.myshop.shop.dto.UserDTO;
import com.myshop.shop.entity.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


public interface UserService {
    String userdata(UserDTO dto);
    default User dtotoUser(UserDTO dto){
        User entity = User.builder()
                .user_id(dto.getUser_id())
                .user_pw(dto.getUser_pw())
                .user_grade(dto.getUser_grade())
                .user_name(dto.getUser_name())
                .user_nickname(dto.getUser_nickname())
                .user_phone(dto.getUser_phone())
                .user_role(dto.getUser_role())
                .user_email(dto.getUser_email())
                .build();
        return entity;
    }
}
