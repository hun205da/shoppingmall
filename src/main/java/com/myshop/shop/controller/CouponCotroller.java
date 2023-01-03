package com.myshop.shop.controller;

import com.myshop.shop.dto.CouponFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CouponCotroller {
    @GetMapping(value = "/admin/coupon/new")
    public String couponForm(Model model){
        model.addAttribute("couponFormDto", new CouponFormDto());
        return "coupon/couponForm";
    }
}
