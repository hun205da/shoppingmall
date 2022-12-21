package com.myshop.shop.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layout/masterlist")
@Log4j2
public class MasterControllerHome {
    @GetMapping("/masterlistHome")
    public void masterlistHome(){

    }
}
/*
@GetMapping("/user/{id}/admin")
  public String adminPage(@PathVariable("id") Integer id, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        User admin = userPageService.findUser(id);
        // User == Admin.Role 일 경우
        if(admin.getRole().equals("ROLE_ADMIN")){
            List<User> userList = userPageService.userList();
            model.addAttribute("user",admin);
            model.addAttribute("userList",userList);
            return "/user/adminpage";
        }else{
            return "redirect:/main";
        }
    }
    @PostMapping("/user/change/{id}")
    public String userChange(@PathVariable("id") Integer id, User user){
        userPageService.userUpdate(id,user);

        return "redirect:/main";
    }
 */
