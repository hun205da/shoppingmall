package com.myshop.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private Long productNumber;
    private String productName;
    private int productPrice;
    private int productStock;
    private String productInfo;
    private int productHits;
    private LocalDateTime regDate, modDate;
}
