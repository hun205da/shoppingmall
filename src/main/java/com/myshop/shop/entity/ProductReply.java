package com.myshop.shop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ProductReply")
@ToString(exclude = {"user","product"})
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductReply extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long replyNumber;
    @Column(length = 50, nullable = false)
    private String content;
    @Column(nullable = false)
    private int replyOrder;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
