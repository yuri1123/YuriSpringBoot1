package com.yuls.yspringboot1.controller;

import com.yuls.yspringboot1.dto.MessageDto;
import com.yuls.yspringboot1.dto.UserDto;
import com.yuls.yspringboot1.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    //아이디 중복 여부 검사
    @ResponseBody
    @PostMapping("/signup/idcheck")
    public int idcheck(@RequestParam("userid") String userid, RedirectAttributes attributes) {
        //아이디로 조회
        UserDto useridcheck = userService.selectbyuserid(userid);
        //아이디가 중복이라면 메시지 보냄
        if (useridcheck != null) {
            return 1;
        } else {
            return 0;
        }
    }

    //회원가입
    @PostMapping("signupdo")
    public ModelAndView signup(UserDto userDto, ModelAndView mav,
                               String userid, RedirectAttributes attributes) {

        userService.createuser(userDto);
        mav.addObject("data", new MessageDto("회원가입이 완료되었습니다.", "/login"));
        mav.setViewName("signup");
        return mav;
    }

}
