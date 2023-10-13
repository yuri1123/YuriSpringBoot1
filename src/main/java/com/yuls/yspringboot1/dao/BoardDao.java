package com.yuls.yspringboot1.dao;

import com.yuls.yspringboot1.dto.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao {

    @Autowired(required = true)
    private SqlSession sqlSession;
    private static final String namespace = "com.yuls.yspringboot1.boardMapper";

    public int create(BoardDto boardDto){
        return sqlSession.insert(namespace +".createboard",boardDto);
    };
    public int update(BoardDto boardDto){
        return sqlSession.update(namespace+".updateboard",boardDto);
    }

    public List<BoardDto> selectboard(){
        return sqlSession.selectList(namespace+".selectboard");
    }

    public BoardDto selectbyid(Long id){
        return sqlSession.selectOne(namespace+".selectbyid",id);
    }

    public int delete(Long id){
        return sqlSession.delete(namespace+".deleteboard",id);
    }



}
