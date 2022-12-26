package com.myshop.shop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ProductCategory")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryCode;
    @Column(length = 50, nullable = false)
    private String categoryName;
    @Column(nullable = true)
    private int categoryRefCode;
}
