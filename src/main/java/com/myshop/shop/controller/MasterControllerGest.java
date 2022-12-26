package com.myshop.shop.controller;

import com.myshop.shop.dto.PageRequestDTO;
import com.myshop.shop.dto.UserDTO;
import com.myshop.shop.entity.User;
import com.myshop.shop.repository.UserRepository;
import com.myshop.shop.service.UserService;
import com.myshop.shop.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/layout/masterlist")
@Log4j2
@RequiredArgsConstructor
public class MasterControllerGest {
    private final UserService service;

    @GetMapping("/masterlistGest")
    public void masterlistGest(PageRequestDTO pagerequestDTO,Model model){
        model.addAttribute("userdto",service.getListDto(pagerequestDTO));
    }

}
