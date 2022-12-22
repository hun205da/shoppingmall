package com.myshop.shop.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = { AuditingEntityListener.class })
@Getter
abstract class BaseEntity {

    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name ="moddate" )
    private LocalDateTime modDate;

    //USER 가입날짜
    @CreatedDate
    @Column(name = "userInsertdate" ,updatable = false)
    private LocalDateTime userInsertdate;
    
    
    //PRODUCT객체_상품 수정날짜
    @LastModifiedDate
    @Column(name = "productDate")
    private LocalDateTime productDate;


    //productreply객체_ 상품후기 작성날짜
    @LastModifiedDate
    @Column(name = "reportingDate")
    private LocalDateTime reportingDate;


}
