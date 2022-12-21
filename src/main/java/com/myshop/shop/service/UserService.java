package com.myshop.shop.service;

import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.dto.PageResultDTO;
import com.myshop.shop.dto.UserDTO;
import com.myshop.shop.dto.UserResultListDTO;
import com.myshop.shop.entity.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


public interface UserService {
    String userdata(UserDTO dto);
    UserResultListDTO<UserDTO,User> getListDto(PageRequestDTO requestDTO);

    default User dtotoUser(UserDTO dto){
        User entity = User.builder()
                .userId(dto.getUserId())
                .userPw(dto.getUserPw())
                .userGrade(dto.getUserGrade())
                .userName(dto.getUserName())
                .userNickname(dto.getUserNickname())
                .userPhone(dto.getUserPhone())
                .userRole(dto.getUserRole())
                .userEmail(dto.getUserEmail())
                .build();
        return entity;
    }
    default UserDTO UserEntityToDTO(User entity){
        UserDTO dto = UserDTO.builder()
                .userId(entity.getUserId())
                .userPw(entity.getUserPw())
                .userGrade(entity.getUserGrade())
                .userName(entity.getUserName())
                .userNickname(entity.getUserNickname())
                .userPhone(entity.getUserPhone())
                .userRole(entity.getUserRole())
                .userEmail(entity.getUserEmail())
                .build();
        return dto;
    }
}
