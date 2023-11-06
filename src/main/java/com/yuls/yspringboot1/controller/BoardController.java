package com.yuls.yspringboot1.controller;

import com.yuls.yspringboot1.dto.*;
import com.yuls.yspringboot1.service.BoardService;
import com.yuls.yspringboot1.service.ReplyService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private ReplyService replyService;

    //게시판 리스트 페이지 가기
    @GetMapping("/board")
    public String goboard(Model model, @ModelAttribute("params") final SearchDto params) {
        System.out.println("게시판으로 가는 길");
        PagingResponse<BoardDto> response = boardService.findAllPost(params);
//        List<BoardDto> boardList = boardService.selectboard(params);
        System.out.println(response);
        model.addAttribute("response", response);

        return "board";
    }


    //글쓰기 페이지 가기
    @GetMapping("/write")
    public String gowriteboard(HttpSession session, RedirectAttributes attributes) {
        Object user = session.getAttribute("user");
        if (user == null) {
            System.out.println("로그인 정보가 없다고! ");
            // 세션 정보가 없을 때 메시지와 리디렉션 정보를 추가합니다.
            attributes.addFlashAttribute("data", new MessageDto("접근권한이 없습니다.로그인이 필요합니다.", "/login"));
            return "redirect:/board"; // board 컨트롤러로 리디렉션합니다.
        } else {
            System.out.println("설마 로그인정보가 없는데 넘어가고 있니?");
            // 세션 정보가 있는 경우 글쓰기 페이지로 이동
            return "createboard";
        }
    }

    //글쓰기
    @PostMapping("/createboard")
    public String writeboard(Model model, BoardDto boardDto) {
        if (boardDto != null) {
            int result = boardService.create(boardDto);
        }

//        List<BoardDto> boardList = boardService.selectboard();
//        model.addAttribute("boardList", boardList);

        return "redirect:/board";
    }

    //게시글 보기(id로 게시물 조회)
    @GetMapping("/boardview/")
    public String boardview(@RequestParam final Long id, final SearchDto queryParams, BoardDto boardDto,
                            Model model, RedirectAttributes attributes, HttpSession session, ReplyDto replyDto) {
        //글쓰기 회원만 접근 가능 판별
        Object user = session.getAttribute("user");
        if (user == null) {
            attributes.addFlashAttribute("data", new MessageDto("접근권한이 없습니다. 로그인이 필요합니다.", "/login"));
            return "redirect:/board"; // board 컨트롤러로 리디렉션합니다.
        } else {
            // 세션 정보가 있는 경우 글쓰기 페이지로 이동
            //게시물 조회
            boardDto = boardService.selectbyid(id);
            if (boardDto != null) {
                model.addAttribute("board", boardDto);
            }
            //게시물 viewcnt +1
            int result = boardService.updateviewcnt(id);
            //댓글 전체 조회
           List<ReplyDto> replyList = replyService.selectReplyAll(id);
            model.addAttribute("replyList",replyList);
            return "boardview";

        }
   }

   //댓글쓰기
    @PostMapping("/createreply")
    public String replycontent(ReplyDto replyDto){
        replyService.createReply(replyDto);
        return "redirect:/board";
    }



    //게시글 수정 페이지 가기
    @GetMapping("/updateboard/")
    public String updateboard(@RequestParam final Long id, BoardDto boardDto, Model model) {
        boardDto = boardService.selectbyid(id);
        if (boardDto != null) {
            model.addAttribute("board", boardDto);
        }
        return "updateboard";
    }

    //게시글 수정
    @PostMapping("/updateboard/{id}")
    public String updateboarddo(@PathVariable("id") Long id, BoardDto boardDto) {
        if (boardDto != null) {
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
    public String deleteboard(@RequestParam final Long id, final SearchDto queryParams, Model model) {
        boardService.deleteboard(id);
        return "redirect:/board";
    }

//
//    //댓글 생성
//    @PostMapping("/select")








}
