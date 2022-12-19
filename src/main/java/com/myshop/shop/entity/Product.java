package com.myshop.shop.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity{
    @Id
    @Column(length = 30,nullable = false)
    private String product_number;
    @Column(length = 50, nullable = true)
    private String product_name;
    @Column(length = 20, nullable = true)
    private String product_price;
    @Column(length = 20, nullable = true)
    private String product_stock;
    @Column(length = 50,  nullable = true)
    private String product_info;
    @Column(length = 20, nullable = true)
    private String product_date;
    @Column(length = 1,  nullable = true)
    private String product_hits;

}
