package com.myshop.shop.service;
import com.myshop.shop.dto.CsDTO;
import com.myshop.shop.dto.CsListPageRequestDTO;
import com.myshop.shop.dto.CsListPageResultDTO;
import com.myshop.shop.entity.Cs;
import org.springframework.data.domain.PageRequest;

public interface CsService {
    Long register(CsDTO dto);

    CsListPageResultDTO<CsDTO, Cs> getList(CsListPageRequestDTO requestDTO);

    default Cs dtoToEntity(CsDTO dto){
        Cs entity = Cs.builder()
                .no(dto.getNo())
                .title(dto.getTitle())
                .text(dto.getText())
                .user_id(dto.getUser_id())
                .build();
        return entity;

    }

    default CsDTO entityToDto(Cs entity){
        CsDTO dto = CsDTO.builder()
                .no(entity.getNo())
                .title(entity.getTitle())
                .text(entity.getText())
                .user_id(entity.getUser_id())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }
}
