package com.myshop.shop.controller;

import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.dto.ProductDTO;
import com.myshop.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
@Log4j2
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

//    @GetMapping("/")
//    public String index() {
//        return "redirect:/product/list";
//    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {
        model.addAttribute("result", service.getList(pageRequestDTO));
    }



    @PostMapping("/view")
    public String read(ProductDTO productDTO, RedirectAttributes redirectAttributes) {
        Long productNumber = service.register(productDTO);
        redirectAttributes.addFlashAttribute("msg", productNumber);
        return "redirect: /product/list";
    }

    @GetMapping("/register")
    public void register(){

    }

    @PostMapping("/register")
    public String register(ProductDTO productDTO, RedirectAttributes redirectAttributes) {
        Long productNumber = service.register(productDTO);
        redirectAttributes.addFlashAttribute("msg", productNumber);
        return "redirect: /product/list";
    }

}

