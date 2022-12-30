package com.myshop.shop.controller;

import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layout")
@Log4j2
@RequiredArgsConstructor
public class SampleController {
    private final ProductService service;
    @GetMapping("/basic")
    public void basic(PageRequestDTO pageRequestDTO, Model model){
        model.addAttribute("result", service.getList(pageRequestDTO));
    }
    @GetMapping("/mypage")
    public void mypage(){

    }
    @GetMapping("/layout1")
    public void la1(){

    }
}
