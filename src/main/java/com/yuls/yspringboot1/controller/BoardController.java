package com.yuls.yspringboot1.controller;

import com.yuls.yspringboot1.dto.BoardDto;
import com.yuls.yspringboot1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    //게시판 가기
    @GetMapping("/board")
    public String goboard(Model model){
        System.out.println("게시판으로 가는 길");
        List<BoardDto> boardList = boardService.selectboard();
        System.out.println(boardList);
        model.addAttribute("boardList",boardList);

        return "board";
    }




}
