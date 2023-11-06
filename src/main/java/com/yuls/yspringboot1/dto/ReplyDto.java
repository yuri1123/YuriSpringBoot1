package com.yuls.yspringboot1.dto;

import com.yuls.yspringboot1.entity.Board;

public class ReplyDto {

    private Long replyid;
    private Long boardid;
    private String replycontent;
    private Integer delete_yn;
    private String regdate;
    private String moddate;
    private String createdby;
    private String modifiedby;

    public ReplyDto(Long replyid, Long boardid, String replycontent, Integer delete_yn, String regdate, String moddate, String createdby, String modifiedby) {
        this.replyid = replyid;
        this.boardid = boardid;
        this.replycontent = replycontent;
        this.delete_yn = delete_yn;
        this.regdate = regdate;
        this.moddate = moddate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
    }

    public Long getReplyid() {
        return replyid;
    }

    public void setReplyid(Long replyid) {
        this.replyid = replyid;
    }

    public Long getBoardid() {
        return boardid;
    }

    public void setBoardid(Long boardid) {
        this.boardid = boardid;
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent;
    }

    public Integer getDelete_yn() {
        return delete_yn;
    }

    public void setDelete_yn(Integer delete_yn) {
        this.delete_yn = delete_yn;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getModdate() {
        return moddate;
    }

    public void setModdate(String moddate) {
        this.moddate = moddate;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getModifiedby() {
        return modifiedby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }

    @Override
    public String toString() {
        return "ReplyDto{" +
                "replyid=" + replyid +
                ", boardid=" + boardid +
                ", replycontent='" + replycontent + '\'' +
                ", delete_yn=" + delete_yn +
                ", regdate='" + regdate + '\'' +
                ", moddate='" + moddate + '\'' +
                ", createdby='" + createdby + '\'' +
                ", modifiedby='" + modifiedby + '\'' +
                '}';
    }
}
