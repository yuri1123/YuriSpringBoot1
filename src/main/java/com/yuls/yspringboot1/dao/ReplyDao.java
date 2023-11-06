package com.yuls.yspringboot1.dao;

import com.yuls.yspringboot1.dto.ReplyDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public class ReplyDao {
    @Autowired(required = true)
    private SqlSession sqlSession;
    private static final String namespace = "com.yuls.yspringboot1.replyMapper";

    //댓글 생성
    public int createReply(ReplyDto replyDto){
        return sqlSession.insert(namespace +".createReply",replyDto);
    };
    //댓글 수정
    public int updateReply(ReplyDto replyDto){
        return sqlSession.update(namespace+".updateReply",replyDto);
    }
    //댓글 전체 조회
    public List<ReplyDto> selectReplyAll(Long boardid){return sqlSession.selectList(namespace+".selectReplyAll",boardid);}
    //게시물 삭제
    public int delete(Map<Long, Long> id){
        return sqlSession.delete(namespace+".deleteReply",id);
    }




}
