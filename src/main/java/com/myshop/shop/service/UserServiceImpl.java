package com.myshop.shop.service;

import com.myshop.shop.dto.*;
import com.myshop.shop.entity.Member;
import com.myshop.shop.repository.MemberRepository;
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

        Page<Member> result = repository.findAll(pageable); //Querydsl 사용

        Function<Member,CakerMemberDTO> fn = (entity -> UserEntityToDTO(entity));

        return new PageResultDTO<>(result, fn);
    }

}
