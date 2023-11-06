package com.yuls.yspringboot1.service;


import com.yuls.yspringboot1.dao.BoardDao;
import com.yuls.yspringboot1.dao.ReplyDao;
import com.yuls.yspringboot1.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class ReplyService {

    //BoardDao 인스턴스 생성
    @Autowired
    private ReplyDao replyDao;

    //댓글 생성
    public int createReply(ReplyDto replyDto) {
        return replyDao.createReply(replyDto);
    }
    //댓글 수정
    public int updateReply(ReplyDto replyDto) {
        return replyDao.updateReply(replyDto);
    }
    //댓글 전체 조회
    public List<ReplyDto> selectReplyAll(Long boardid) {
        return replyDao.selectReplyAll(boardid);
    }
    //댓글 삭제
    public int deleteReply(Map<Long,Long> params) {
        return replyDao.delete(params);
    }

}
