package com.myshop.shop.service;

import com.myshop.shop.dto.FaqDTO;
import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.dto.PageResultDTO;
import com.myshop.shop.entity.Faq;

public interface FaqService {

    Long register(FaqDTO dto);

    PageResultDTO<FaqDTO, Faq> getList(PageRequestDTO requestDTO);

    FaqDTO read(Long no);

    void modify(FaqDTO dto);

    void remove(Long no);

    default Faq dtoToEntity(FaqDTO dto) {
        Faq entity = Faq.builder()
                .no(dto.getNo())
                .title(dto.getTitle())
                .category(dto.getCategory())
                .text(dto.getText())
                .build();
        return entity;
    }

    default FaqDTO entityToDto(Faq entity){

        FaqDTO dto  = FaqDTO.builder()
                .no(entity.getNo())
                .title(entity.getTitle())
                .category(entity.getCategory())
                .text(entity.getText())
                .regDate(entity.getRegTime())
                .modDate(entity.getUpdateTime())
                .build();

        return dto;
    }
}
