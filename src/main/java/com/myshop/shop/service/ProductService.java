package com.myshop.shop.service;

import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.dto.PageResultDTO;
import com.myshop.shop.dto.ProductDTO;
import com.myshop.shop.dto.ProductImageDTO;
import com.myshop.shop.entity.Product;
import com.myshop.shop.entity.ProductImage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface ProductService {
    Long register(ProductDTO dto);
    PageResultDTO<ProductDTO, Product> getList(PageRequestDTO requestDTO);
    ProductDTO read(Long productNumber);
    default Map<String, Object> dtoToEntity(ProductDTO dto) {
        Map<String, Object> entityMap = new HashMap<>();
        Product product = Product.builder()
                .productNumber(dto.getProductNumber())
                .productName(dto.getProductName())
                .productPrice(dto.getProductPrice())
                .productStock(dto.getProductStock())
                .productInfo(dto.getProductInfo())
                .productHits(dto.getProductHits())
                .build();

        entityMap.put("product", product);

        List<ProductImageDTO> imageDTOList = dto.getImageDTOList();

        if (imageDTOList != null && imageDTOList.size() > 0) {
            List<ProductImage> productImageList = imageDTOList.stream().map(productImageDTO -> {
                ProductImage productImage = ProductImage.builder()
                        .path(productImageDTO.getPath())
                        .imageName(productImageDTO.getImageName())
                        .uuid(productImageDTO.getUuid())
                        .product(product)
                        .build();
                return productImage;
            }).collect(Collectors.toList());
            entityMap.put("imgList", productImageList);
        }
        return entityMap;
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
