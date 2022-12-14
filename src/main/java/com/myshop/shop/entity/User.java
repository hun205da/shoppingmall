package com.myshop.shop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Product")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long product_number;
    @Column(length = 50,nullable = false)
    private String product_name;
}
