package com.myshop.shop.service;

import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.dto.PageResultDTO;
import com.myshop.shop.dto.ProductDTO;
import com.myshop.shop.entity.Product;
import com.myshop.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;


@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public Long register(ProductDTO dto) {
        Product entity = dtoToEntity(dto);

        repository.save(entity);

        return entity.getProductNumber();
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
}
