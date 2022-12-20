package com.myshop.shop.controller;

import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.service.FaqService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faq")
@Log4j2
@RequiredArgsConstructor
public class FaqController {
    private final FaqService service;

    @GetMapping("/")
    public String index(){
        return "redirect:/faq/list";
    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        log.info("list....................." + pageRequestDTO);

        model.addAttribute("result", service.getList(pageRequestDTO));
    }
}
