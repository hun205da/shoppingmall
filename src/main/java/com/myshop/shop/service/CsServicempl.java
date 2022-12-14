package com.myshop.shop.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.myshop.shop.dto.CsDTO;
import com.myshop.shop.dto.CsListPageRequestDTO;
import com.myshop.shop.dto.CsListPageResultDTO;
import com.myshop.shop.entity.Cs;
import com.myshop.shop.repositoty.CsRepository;

import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class CsServicempl implements CsService {

    private final CsRepository repository;//반드시 final로 선언

    @Override
    public Long register(CsDTO dto){
        log.info("DTO------------------------------------------------");
        log.info(dto);

        Cs entity = dtoToEntity(dto);

        log.info(entity);

        repository.save(entity);

        return entity.getNo();

    }

    @Override
    public CsListPageResultDTO<CsDTO, Cs> getList(CsListPageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());

        Page<Cs> result = repository.findAll(pageable);

        Function<Cs, CsDTO> fn = (entity -> entityToDto(entity));

        return new CsListPageResultDTO<>(result, fn );
    }

}
