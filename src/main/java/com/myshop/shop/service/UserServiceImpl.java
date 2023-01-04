package com.myshop.shop.service;

import com.myshop.shop.dto.*;
import com.myshop.shop.entity.Member;
import com.myshop.shop.entity.QMember;
import com.myshop.shop.repository.MemberRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final MemberRepository repository;
    @Override
    public PageResultDTO<CakerMemberDTO, Member> getListDto(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("id").descending());
        BooleanBuilder booleanBuilder = getSearch(requestDTO);
        Page<Member> result = repository.findAll(booleanBuilder,pageable); //Querydsl 사용

        Function<Member,CakerMemberDTO> fn = (entity -> UserEntityToDTO(entity));

        return new PageResultDTO<>(result, fn);
    }
    private BooleanBuilder getSearch(PageRequestDTO requestDTO){

        String type = requestDTO.getType();
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        String keyword = requestDTO.getKeyword();
        QMember qmember = QMember.member;
        if(type == null || type.trim().length() == 0){ //검색 조건이 없는 경우
            return booleanBuilder;
        }

        //검색 조건을 작성하기
        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if(type.contains("uemail")){
            conditionBuilder.or(qmember.email.contains(keyword));
        }
        if(type.contains("uname")){
            conditionBuilder.or(qmember.name.contains(keyword));
        }
        if(type.contains("urole")){
            conditionBuilder.or(qmember.role.stringValue().contains(keyword));
        }

        //모든 조건 통합
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }
}
