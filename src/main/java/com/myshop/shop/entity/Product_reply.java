package com.myshop.shop.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product_reply")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product_reply {
    @Id
    @Column(length = 30,nullable = false)
    private int replyNumber;
    @Column(length = 50, nullable = true)
    private String content;
    @Column(length = 50, nullable = true)
    private String writerNicknamee;
    @Column(length = 20, nullable = true)
    private String reportingDate;
    @Column(length = 50,  nullable = true)
    private String replyOriginNumber;
    @Column(length = 20, nullable = true)
    private String replyOrder;
    @Column(length = 1,  nullable = true)
    private String productNumber;
}
