package com.myshop.shop.service;

import com.myshop.shop.dto.CsDTO;
import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.dto.PageResultDTO;
import com.myshop.shop.entity.Cs;
import com.myshop.shop.entity.Member;

public interface CsService {


    Long register(CsDTO dto);

    PageResultDTO<CsDTO, Cs> getList(PageRequestDTO requestDTO);

    CsDTO read(Long no);

    void modify(CsDTO dto);

    void reply(CsDTO dto);

    void remove(Long no);

    default Cs dtoToEntity(CsDTO dto) {
        Cs entity = Cs.builder()
                .no(dto.getNo())
                .title(dto.getTitle())
                .category(dto.getCategory())
                .text(dto.getText())
                .reply(dto.getReply())
                .build();
        return entity;
    }

    default CsDTO entityToDto(Cs entity){

        CsDTO dto  = CsDTO.builder()
                .no(entity.getNo())
                .title(entity.getTitle())
                .category(entity.getCategory())
                .text(entity.getText())
                .reply(entity.getReply())
                .regDate(entity.getRegTime())
                .modDate(entity.getUpdateTime())
                .build();

        return dto;
    }
}
