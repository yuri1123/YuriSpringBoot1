package com.yuls.yspringboot1.controller;

import com.yuls.yspringboot1.dto.BoardDto;
import com.yuls.yspringboot1.dto.PagingResponse;
import com.yuls.yspringboot1.dto.SearchDto;
import com.yuls.yspringboot1.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    //게시판 리스트 페이지 가기
    @GetMapping("/board")
    public String goboard(Model model, @ModelAttribute("params") final SearchDto params){
        System.out.println("게시판으로 가는 길");
        PagingResponse<BoardDto> response = boardService.findAllPost(params);
//        List<BoardDto> boardList = boardService.selectboard(params);
        System.out.println(response);
        model.addAttribute("response",response);

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
    @GetMapping("/boardview/")
    public String boardview(@RequestParam final Long id,final SearchDto queryParams, BoardDto boardDto, Model model){
        boardDto = boardService.selectbyid(id);
        if(boardDto != null) {
            model.addAttribute("board", boardDto);
        }
    return "boardview";
    }

    //게시글 수정 페이지 가기
    @GetMapping("/updateboard/")
    public String updateboard(@RequestParam final Long id, BoardDto boardDto, Model model){
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

    // 쿼리 스트링 파라미터를 Map에 담아 반환
    private Map<String, Object> queryParamsToMap(final SearchDto queryParams) {
        Map<String, Object> data = new HashMap<>();
        data.put("page", queryParams.getPage());
        data.put("recordSize", queryParams.getRecordSize());
        data.put("pageSize", queryParams.getPageSize());
        data.put("keyword", queryParams.getKeyword());
        data.put("searchType", queryParams.getSearchType());
        return data;
    }

    //게시글 삭제
    @PostMapping("/deleteboard/")
    public String deleteboard(@RequestParam final Long id,final SearchDto queryParams, Model model){
            boardService.deleteboard(id);

        return "redirect:/board";
    }

}
