package com.yuls.yspringboot1.controller;

import com.yuls.yspringboot1.dto.MessageDto;
import com.yuls.yspringboot1.dto.UserDto;
import com.yuls.yspringboot1.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //로그인페이지 가기
    @GetMapping("login")
    public String loginform() {

        return "login";
    }

    //로그인하기
    @PostMapping("login")
    public String login(UserDto userDto, HttpSession session) {
        UserDto user = userService.login(userDto);
        if (user == null) {
            System.out.println("패스워드 또는 아이디가 일치하지 않습니다.");
        } else {
            session.setAttribute("user", user);
        }
        return "redirect:/";
    }

    //로그아웃하기
    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    //회원가입 페이지 가기
    @GetMapping("signup")
    public String signupform() {
        return "signup";
    }

    //회원가입
    @PostMapping("signupdo")
    public ModelAndView signup(UserDto userDto, ModelAndView mav) {
        userService.createuser(userDto);
        mav.addObject("data", new MessageDto("회원가입이 완료되었습니다.", "/login"));
        mav.setViewName("signup");
        return mav;
    }

}
