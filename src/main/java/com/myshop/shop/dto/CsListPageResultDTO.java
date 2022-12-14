package com.myshop.shop.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class CsListPageResultDTO<DTO, EN> {

    private List<DTO> dtoList;

    public CsListPageResultDTO(Page<EN> result , Function<EN, DTO> fn){

        dtoList = result.stream().map(fn).collect(Collectors.toList());
    }


}
