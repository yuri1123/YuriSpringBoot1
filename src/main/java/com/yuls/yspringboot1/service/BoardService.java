package com.yuls.yspringboot1.service;


import com.yuls.yspringboot1.dao.BoardDao;
import com.yuls.yspringboot1.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardDao boardDao;

    public int create(BoardDto boardDto){
        return boardDao.create(boardDto);
    }

    public int update(BoardDto boardDto){
        return boardDao.update(boardDto);
    }

    public List<BoardDto> selectboard(){
        return boardDao.selectboard();
    }

    public BoardDto selectbyid(Long id){
        return boardDao.selectbyid(id);
    }

    public int deleteboard(Long id){
        return boardDao.delete(id);
    }


}
