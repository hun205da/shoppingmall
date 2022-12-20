package com.myshop.shop.service;

import com.myshop.shop.dto.FaqDTO;
import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.dto.PageResultDTO;
import com.myshop.shop.entity.Faq;
import com.myshop.shop.repository.FaqRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class FaqServicempl implements FaqService {

    private final FaqRepository repository;

    @Override
    public Long register(FaqDTO dto) {
        log.info("DTO--------------------------------");
        log.info(dto);

        Faq entity = dtoToEntity(dto);

        log.info(entity);

        repository.save(entity);

        return entity.getNo();
    }

    @Override
    public PageResultDTO<FaqDTO, Faq> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("no").descending());

        Page<Faq> result = repository.findAll(pageable);

        Function<Faq, FaqDTO> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result, fn );
    }
}
