package com.yuls.yspringboot1.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(HttpSession session){
        System.out.println("메인페이지입니다.");
        String user = session.getId();
        System.out.println(user);
        return "index";
    }


}
