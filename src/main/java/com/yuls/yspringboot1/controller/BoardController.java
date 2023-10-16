package com.yuls.yspringboot1.controller;

import com.yuls.yspringboot1.dto.BoardDto;
import com.yuls.yspringboot1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    //게시판 리스트 페이지 가기
    @GetMapping("/board")
    public String goboard(Model model){
        System.out.println("게시판으로 가는 길");
        List<BoardDto> boardList = boardService.selectboard();
//        System.out.println(boardList);
        model.addAttribute("boardList",boardList);

        return "board";
    }

    //글쓰기 페이지 가기
    @GetMapping("/write")
    public String gowriteboard(Model model){
        System.out.println("글쓰기가기");
        return "createboard";
    }

    //글쓰기
    @PostMapping("/createboard")
    public String writeboard(Model model,BoardDto boardDto){
        if(boardDto != null){
            int result = boardService.create(boardDto);
        }
//        List<BoardDto> boardList = boardService.selectboard();
//        model.addAttribute("boardList", boardList);

        return "redirect:/board";
    }

    //게시글 보기
    @GetMapping("/boardview/{id}")
    public String boardview(@PathVariable("id") Long id, BoardDto boardDto, Model model){
        boardDto = boardService.selectbyid(id);
        if(boardDto != null) {
            model.addAttribute("board", boardDto);
        }
    return "boardview";
    }

    //게시글 수정 페이지 가기
    @GetMapping("/updateboard/{id}")
    public String updateboard(@PathVariable("id") Long id, BoardDto boardDto, Model model){
        boardDto = boardService.selectbyid(id);
        if(boardDto != null) {
            model.addAttribute("board", boardDto);
        }
        return "updateboard";
    }

    //게시글 수정
    @PostMapping("/updateboard/{id}")
    public String updateboarddo(@PathVariable("id") Long id,BoardDto boardDto){
        if(boardDto != null) {
            int result = boardService.update(boardDto);
        }
        return "reidrect:/board";
    }

    //게시글 삭제
    @PostMapping("/deleteboard/{id}")
    public String deleteboard(@PathVariable("id") Long id){
        if(id != null) {
            int result = boardService.deleteboard(id);
        }
        return "redirect:/board";
    }

}
