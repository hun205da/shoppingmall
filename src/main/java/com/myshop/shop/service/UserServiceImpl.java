package com.myshop.shop.service;

import com.myshop.shop.dto.*;
import com.myshop.shop.entity.Cs;
import com.myshop.shop.entity.QCs;
import com.myshop.shop.entity.QUser;
import com.myshop.shop.entity.User;
import com.myshop.shop.repository.UserRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
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
        BooleanBuilder booleanBuilder = getSearch(requestDTO);

        Page<User> result = repository.findAll(booleanBuilder,pageable); //Querydsl 사용

        Function<User, UserDTO> fn = (entity -> UserEntityToDTO(entity));

        return new UserResultListDTO<>(result, fn);
    }
    private BooleanBuilder getSearch(PageRequestDTO requestDTO){
        String type = requestDTO.getType();
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        String keyword = requestDTO.getKeyword();
        QUser qUser = QUser.user;
        if(type == null || type.trim().length() == 0){ //검색 조건이 없는 경우
            return booleanBuilder;
        }


        //검색 조건을 작성하기
        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if(type.contains("uid")){
            conditionBuilder.or(qUser.userId.contains(keyword));
        }
        if(type.contains("upw")){
            conditionBuilder.or(qUser.userPw.contains(keyword));
        }
        if(type.contains("uname")){
            conditionBuilder.or(qUser.userName.contains(keyword));
        }

        //모든 조건 통합
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }





}
