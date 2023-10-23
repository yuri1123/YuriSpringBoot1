package com.yuls.yspringboot1.service;


import com.yuls.yspringboot1.dao.BoardDao;
import com.yuls.yspringboot1.dto.BoardDto;
import com.yuls.yspringboot1.dto.Pagination;
import com.yuls.yspringboot1.dto.PagingResponse;
import com.yuls.yspringboot1.dto.SearchDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardDao boardDao;

    public int create(BoardDto boardDto) {
        return boardDao.create(boardDto);
    }

    public int update(BoardDto boardDto) {
        return boardDao.update(boardDto);
    }

    public List<BoardDto> selectboard(SearchDto params) {
        return boardDao.selectboard(params);
    }

    public BoardDto selectbyid(Long id) {
        return boardDao.selectbyid(id);
    }

    public int deleteboard(Long id) {
        return boardDao.delete(id);
    }

    //게시글 리스트 조회
//    * @param params - search conditions
//    * @return list & pagination information
    public PagingResponse<BoardDto> findAllPost(SearchDto params) {
        // 조건에 해당하는 데이터가 없는 경우, 응답 데이터에 비어있는 리스트와 null을 담아 반환
        int count = boardDao.count(params);
        if (count < 1) {
            return new PagingResponse<>(Collections.emptyList(), null);
        }
        System.out.println(count);
        // Pagination 객체를 생성해서 페이지 정보 계산 후 SearchDto 타입의 객체인 params에 계산된 페이지 정보 저장
        Pagination pagination = new Pagination(count, params);
        params.setPagination(pagination);

        // 계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로 리스트 데이터 조회 후 응답 데이터 반환
        List<BoardDto> list = boardDao.selectboard(params);
        return new PagingResponse<>(list, pagination);
    }

}
