package com.myshop.shop.service;

import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.dto.PageResultDTO;
import com.myshop.shop.dto.ProductDTO;
import com.myshop.shop.entity.Product;
import com.myshop.shop.entity.ProductImage;
import com.myshop.shop.entity.QCs;
import com.myshop.shop.entity.QProduct;
import com.myshop.shop.repository.ProductImageRepository;
import com.myshop.shop.repository.ProductRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;


@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductImageRepository imageRepository;

    @Transactional
    @Override
    public Long register(ProductDTO dto) {
        Map<String, Object> entityMap = dtoToEntity(dto);
        Product product = (Product) entityMap.get("product");
        List<ProductImage> productImageList = (List<ProductImage>) entityMap.get("imgList");
        repository.save(product);
        productImageList.forEach(productImage -> {
            imageRepository.save(productImage);
        });
        return product.getProductNumber();
    }

    @Override
    public PageResultDTO<ProductDTO, Product> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("productNumber").descending());
        Page<Product> result = repository.findAll(pageable);
        Function<Product, ProductDTO> fn = (entity -> entityToDto(entity));
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public ProductDTO read(Long productNumber) {
        Optional<Product> result = repository.findById(productNumber);

        return result.isPresent()? entityToDto(result.get()): null;
    }

    private BooleanBuilder getSearch(PageRequestDTO requestDTO){

        String type = requestDTO.getType();

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        QProduct qProduct = QProduct.product;

        String keyword = requestDTO.getKeyword();

        BooleanExpression expression = qProduct.productNumber.gt(0L); // no > 0 조건만 생성

        booleanBuilder.and(expression);

        if(type == null || type.trim().length() == 0){ //검색 조건이 없는 경우
            return booleanBuilder;
        }


        //검색 조건을 작성하기
        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if(type.contains("t")) {
            conditionBuilder.or(qProduct.productName.contains(keyword));
        }

        //모든 조건 통합
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }
}
