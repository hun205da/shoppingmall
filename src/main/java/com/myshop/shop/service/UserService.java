package com.myshop.shop.service;

import com.myshop.shop.constant.Role;
import com.myshop.shop.dto.CakerMemberDTO;
import com.myshop.shop.dto.MemberFormDto;
import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.dto.PageResultDTO;
import com.myshop.shop.entity.Member;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


public interface UserService {
    PageResultDTO<CakerMemberDTO,Member> getListDto(PageRequestDTO requestDTO);

    default CakerMemberDTO UserEntityToDTO(Member entity){
        CakerMemberDTO dto = CakerMemberDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .role(entity.getRole())
                .build();
        return dto;
    }
}
