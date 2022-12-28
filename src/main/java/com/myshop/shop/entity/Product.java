package com.myshop.shop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Product")
@ToString(exclude = "productCategory")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productNumber;
    @Column(length = 50, nullable = false)
    private String productName;
    @Column(nullable = false)
    private int productPrice;
    @Column(nullable = false)
    private int productStock;
    @Column(length = 100,  nullable = true)
    private String productInfo;
    @Column(length = 20, nullable = true)
    private int productHits;
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductCategory productCategory;
}
