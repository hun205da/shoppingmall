package com.myshop.shop.controller;

import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layout/masterlist")
@Log4j2
@RequiredArgsConstructor
public class MasterController {
    private final UserService service;
    @GetMapping("/")
    public String index(){
        return "redirect:/layout/masterlist/masterlistGest";
    }
    @GetMapping("/masterlistHome")
    public void masterlistHome(){

    }
    @GetMapping("/masterlistCartlist")
    public void masterlistCartlist(){

    }


    @GetMapping("/masterlistGest")
    public void masterlistGest(PageRequestDTO pagerequestDTO, Model model){
        model.addAttribute("userdto",service.getListDto(pagerequestDTO));
    }

    @GetMapping("/masterlistList")
    public void masterlistList(){

    }
    @GetMapping("/masterlistSoldlist")
    public void masterlistSoldlist(){

    }
}
