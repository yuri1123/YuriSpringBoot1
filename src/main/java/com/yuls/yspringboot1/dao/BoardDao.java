package com.yuls.yspringboot1.dao;

import com.yuls.yspringboot1.dto.BoardDto;
import com.yuls.yspringboot1.dto.SearchDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao {

    @Autowired(required = true)
    private SqlSession sqlSession;
    private static final String namespace = "com.yuls.yspringboot1.boardMapper";

    //게시물 생성
    public int create(BoardDto boardDto){
        return sqlSession.insert(namespace +".createboard",boardDto);
    };
    //게시물 수정
    public int update(BoardDto boardDto){
        return sqlSession.update(namespace+".updateboard",boardDto);
    }

    //전체조회, 페이징, 검색
    public List<BoardDto> selectboard(SearchDto params){
        return sqlSession.selectList(namespace+".selectboard",params);
    }
    //게시물 갯수 카운트
    public int count(SearchDto params){
        return sqlSession.selectOne(namespace+".count",params);}

    //id로 조회
    public BoardDto selectbyid(Long id){
        return sqlSession.selectOne(namespace+".selectbyid",id);
    }

    //게시물 조회수 +1
    public int updateviewcnt(Long id){return sqlSession.update(namespace+".updateviewcnt",id);}
    //게시물 삭제
    public int delete(Long id){
        return sqlSession.delete(namespace+".deleteboard",id);
    }




}
