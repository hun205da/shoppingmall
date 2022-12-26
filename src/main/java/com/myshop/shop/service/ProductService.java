package com.myshop.shop.service;

import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.dto.PageResultDTO;
import com.myshop.shop.dto.ProductDTO;
import com.myshop.shop.entity.Product;

public interface ProductService {
    Long register(ProductDTO dto);
    PageResultDTO<ProductDTO, Product> getList(PageRequestDTO requestDTO);
    ProductDTO read(Long productNumber);
    default Product dtoToEntity(ProductDTO dto) {
        Product entity = Product.builder()
                .productNumber(dto.getProductNumber())
                .productName(dto.getProductName())
                .productPrice(dto.getProductPrice())
                .productStock(dto.getProductStock())
                .productInfo(dto.getProductInfo())
                .productHits(dto.getProductHits())
                .build();
        return entity;
    }

    default ProductDTO entityToDto(Product entity) {
        ProductDTO dto = ProductDTO.builder()
                .productNumber(entity.getProductNumber())
                .productName(entity.getProductName())
                .productPrice(entity.getProductPrice())
                .productStock(entity.getProductStock())
                .productInfo(entity.getProductInfo())
                .productHits(entity.getProductHits())
                .build();
        return dto;
    }
}
