package com.myshop.shop.repository;


import com.myshop.shop.dto.ItemSearchDto;
import com.myshop.shop.dto.MainItemDto;
import com.myshop.shop.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ItemRepositoryCustom {

    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

}