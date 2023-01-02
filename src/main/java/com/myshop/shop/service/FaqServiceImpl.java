package com.myshop.shop.service;

import com.myshop.shop.dto.FaqDTO;
import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.dto.PageResultDTO;
import com.myshop.shop.entity.Faq;
import com.myshop.shop.entity.QFaq;
import com.myshop.shop.repository.FaqRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class FaqServiceImpl implements FaqService {

    private final FaqRepository repository;

    @Override
    public Long register(FaqDTO dto) {

        log.info("DTO------------------------");
        log.info(dto);

        Faq entity = dtoToEntity(dto);

        log.info(entity);

        repository.save(entity);

        return entity.getNo();
    }

//    @Override
//    public PageResultDTO<FaqDTO, Faq> getList(PageRequestDTO requestDTO) {
//
//        Pageable pageable = requestDTO.getPageable(Sort.by("no").descending());
//
//        Page<Faq> result = repository.findAll(pageable);
//
//        Function<Faq, FaqDTO> fn = (entity -> entityToDto(entity));
//
//        return new PageResultDTO<>(result, fn );
//    }

    @Override
    public PageResultDTO<FaqDTO, Faq> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("no").descending());

        BooleanBuilder booleanBuilder = getSearch(requestDTO); //검색 조건 처리

        Page<Faq> result = repository.findAll(booleanBuilder, pageable); //Querydsl 사용

        Function<Faq, FaqDTO> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result, fn );
    }


    @Override
    public FaqDTO read(Long no) {

        Optional<Faq> result = repository.findById(no);

        return result.isPresent()? entityToDto(result.get()): null;
    }

    @Override
    public void remove(Long no) {

        repository.deleteById(no);

    }

    @Override
    public void modify(FaqDTO dto) {

        //업데이트 하는 항목은 '제목', '내용'

        Optional<Faq> result = repository.findById(dto.getNo());

        if(result.isPresent()){

            Faq entity = result.get();

            entity.changeTitle(dto.getTitle());
            entity.changeText(dto.getText());
            entity.changeCategory(dto.getCategory());

            repository.save(entity);

        }
    }


    private BooleanBuilder getSearch(PageRequestDTO requestDTO){

        String type = requestDTO.getType();

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        QFaq qfaq = QFaq.faq;

        String keyword = requestDTO.getKeyword();

        BooleanExpression expression = qfaq.no.gt(0L); // no > 0 조건만 생성

        booleanBuilder.and(expression);

        if(type == null || type.trim().length() == 0){ //검색 조건이 없는 경우
            return booleanBuilder;
        }


        //검색 조건을 작성하기
        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if(type.contains("t")){
            conditionBuilder.or(qfaq.title.contains(keyword));
        }
        if(type.contains("c")){
            conditionBuilder.or(qfaq.text.contains(keyword));
        }

        //모든 조건 통합
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }

}
