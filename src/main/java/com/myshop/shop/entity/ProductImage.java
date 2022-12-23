package com.myshop.shop.entity;

import lombok.*;

import javax.persistence.*;
@Entity
@Table(name = "ProductCategory")
@ToString(exclude = "Product")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long imageNumber;
        @Column(length = 50, nullable = false)
        private String imageName;
        @Column(length = 50, nullable = false)
        private String path;
        @Column(nullable = false)
        private int uuid;
        @ManyToOne(fetch = FetchType.LAZY)
        private Product product;
}
