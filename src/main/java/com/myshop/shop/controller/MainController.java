package com.myshop.shop.controller;

import com.myshop.shop.dto.UserDTO;
import com.myshop.shop.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/layout")
@RequiredArgsConstructor
public class MainController {
    private final UserService service;
    @GetMapping("/join")
    public void join(){
    }
    @GetMapping("/login")
    public void login(){

    }
    @PostMapping("/join")
    public String joinPost(UserDTO dto, RedirectAttributes redirectAttributes) {
        String userId = service.userdata(dto);

        redirectAttributes.addFlashAttribute("userid",userId);

        return "redirect:/layout/basic";
    }
}
