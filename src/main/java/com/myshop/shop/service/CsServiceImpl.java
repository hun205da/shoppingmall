package com.myshop.shop.service;

import com.myshop.shop.dto.CsDTO;
import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.dto.PageResultDTO;
import com.myshop.shop.entity.Cs;
import com.myshop.shop.entity.QCs;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.myshop.shop.repository.CsRepository;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class CsServiceImpl implements CsService {

    private final CsRepository repository;

    @Override
    public Long register(CsDTO dto) {

        log.info("DTO------------------------");
        log.info(dto);

        Cs entity = dtoToEntity(dto);

        log.info(entity);

        repository.save(entity);

        return entity.getNo();
    }

//    @Override
//    public PageResultDTO<CsDTO, Cs> getList(PageRequestDTO requestDTO) {
//
//        Pageable pageable = requestDTO.getPageable(Sort.by("no").descending());
//
//        Page<Cs> result = repository.findAll(pageable);
//
//        Function<Cs, CsDTO> fn = (entity -> entityToDto(entity));
//
//        return new PageResultDTO<>(result, fn );
//    }

    @Override
    public PageResultDTO<CsDTO, Cs> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("no").descending());

        BooleanBuilder booleanBuilder = getSearch(requestDTO); //검색 조건 처리

        Page<Cs> result = repository.findAll(booleanBuilder, pageable); //Querydsl 사용

        Function<Cs, CsDTO> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result, fn );
    }


    @Override
    public CsDTO read(Long no) {

        Optional<Cs> result = repository.findById(no);

        return result.isPresent()? entityToDto(result.get()): null;
    }

    @Override
    public void remove(Long no) {

        repository.deleteById(no);

    }

    @Override
    public void modify(CsDTO dto) {

        //업데이트 하는 항목은 '제목', '내용'

        Optional<Cs> result = repository.findById(dto.getNo());

        if(result.isPresent()){

            Cs entity = result.get();

            entity.changeTitle(dto.getTitle());
            entity.changeText(dto.getText());
            entity.changeCategory(dto.getCategory());

            repository.save(entity);

        }
    }

    @Override
    public void reply(CsDTO dto) {

        //업데이트 하는 항목은 '제목', '내용'

        Optional<Cs> result = repository.findById(dto.getNo());

        if(result.isPresent()){

            Cs entity = result.get();

            entity.changeReply(dto.getReply());

            repository.save(entity);

        }
    }

    private BooleanBuilder getSearch(PageRequestDTO requestDTO){

        String type = requestDTO.getType();

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        QCs qcs = QCs.cs;

        String keyword = requestDTO.getKeyword();

        BooleanExpression expression = qcs.no.gt(0L); // no > 0 조건만 생성

        booleanBuilder.and(expression);

        if(type == null || type.trim().length() == 0){ //검색 조건이 없는 경우
            return booleanBuilder;
        }


        //검색 조건을 작성하기
        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if(type.contains("t")) {
            conditionBuilder.or(qcs.title.contains(keyword));
        }

        //모든 조건 통합
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }

}
