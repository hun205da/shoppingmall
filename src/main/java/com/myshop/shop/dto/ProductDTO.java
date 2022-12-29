package com.myshop.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Builder.Default
    private List<ProductImageDTO> imageDTOList = new ArrayList<>();
}
