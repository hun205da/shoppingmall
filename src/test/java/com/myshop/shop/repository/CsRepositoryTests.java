package com.myshop.shop.repository;

import com.myshop.shop.entity.Cs;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.myshop.shop.entity.QCs;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class CsRepositoryTests {

    @Autowired
    private CsRepository csRepository;

    @Test
    public void insertDummies(){

        IntStream.rangeClosed(1,300).forEach(i -> {

            Cs cs = Cs.builder()
                    .title("Title...." + i)
                    .content("Content..." +i)
                    .writer("user" + (i % 10))
                    .build();
            System.out.println(csRepository.save(cs));
        });
    }

    @Test
    public void updateTest() {

        Optional<Cs> result = csRepository.findById(300L); //존재하는 번호로 테스트

        if(result.isPresent()){

            Cs cs = result.get();

            cs.changeTitle("Changed Title....");
            cs.changeContent("Changed Content...");

            csRepository.save(cs);
        }
    }

    @Test
    public void testQuery1() {

        Pageable pageable = PageRequest.of(0, 10, Sort.by("no").descending());

        QCs qCs = QCs.cs; //1

        String keyword = "1";

        BooleanBuilder builder = new BooleanBuilder();  //2

        BooleanExpression expression = qCs.title.contains(keyword); //3

        builder.and(expression); //4

        Page<Cs> result = csRepository.findAll(builder, pageable); //5

        result.stream().forEach(cs -> {
            System.out.println(cs);
        });

    }

    @Test
    public void testQuery2() {

        Pageable pageable = PageRequest.of(0, 10, Sort.by("no").descending());

        QCs qCs = QCs.cs;

        String keyword = "1";

        BooleanBuilder builder = new BooleanBuilder();

        BooleanExpression exTitle =  qCs.title.contains(keyword);

        BooleanExpression exContent =  qCs.content.contains(keyword);

        BooleanExpression exAll = exTitle.or(exContent); // 1----------------

        builder.and(exAll); //2-----

        builder.and(qCs.no.gt(0L)); // 3-----------

        Page<Cs> result = csRepository.findAll(builder, pageable);

        result.stream().forEach(cs -> {
            System.out.println(cs);
        });

    }

}
