package com.myshop.shop.service;

import com.myshop.shop.dto.*;
import com.myshop.shop.entity.Cs;
import com.myshop.shop.entity.User;
import com.myshop.shop.repository.UserRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    @Override
    public String userdata(UserDTO dto) {
        User entity = dtotoUser(dto);
        repository.save(entity);
        return entity.getUserId();
    }

    @Override
    public UserResultListDTO<UserDTO, User> getListDto(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("userId").descending());

        Page<User> result = repository.findAll(pageable); //Querydsl 사용

        Function<User, UserDTO> fn = (entity -> UserEntityToDTO(entity));

        return new UserResultListDTO<>(result, fn);
    }




}
