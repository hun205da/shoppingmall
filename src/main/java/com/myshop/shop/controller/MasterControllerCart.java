package com.myshop.shop.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layout/masterlist")
@Log4j2
public class MasterControllerCart {
    @GetMapping("/masterlist_cartlist")
    public void masterlist_cartlist(){

    }


}
