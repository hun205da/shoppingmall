package com.myshop.shop.controller;

import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layout/masterlist")
@Log4j2
@RequiredArgsConstructor
public class MasterControllerGest {
    private final UserService service;

    @GetMapping("/masterlistGest")
    public void masterlistGest(PageRequestDTO pagerequestDTO,Model model){
        model.addAttribute("memberdto",service.getListDto(pagerequestDTO));
    }

}
