package com.myshop.shop.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layout/masterlist")
@Log4j2
public class MasterControllerSold {
    @GetMapping("/masterlistSoldlist")
    public void masterlistSoldlist(){

    }


}
