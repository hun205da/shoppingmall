package com.myshop.shop.service;

import com.myshop.shop.dto.UserDTO;
import com.myshop.shop.entity.User;
import com.myshop.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    @Override
    public String userdata(UserDTO dto) {
        User entity = dtotoUser(dto);
        repository.save(entity);
        return entity.getUser_id();
    }

}
