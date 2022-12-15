package com.myshop.shop.service;

import com.myshop.shop.dto.CsDTO;
import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.dto.PageResultDTO;
import com.myshop.shop.entity.Cs;

public interface CsService {

    Long register(CsDTO dto);

    PageResultDTO<CsDTO, Cs> getList(PageRequestDTO requestDTO);

    CsDTO read(Long no);

    void modify(CsDTO dto);

    void remove(Long no);

    default Cs dtoToEntity(CsDTO dto) {
        Cs entity = Cs.builder()
                .no(dto.getNo())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
        return entity;
    }

    default CsDTO entityToDto(Cs entity){

        CsDTO dto  = CsDTO.builder()
                .no(entity.getNo())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();

        return dto;
    }
}
