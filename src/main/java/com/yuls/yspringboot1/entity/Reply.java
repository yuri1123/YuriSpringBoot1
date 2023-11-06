package com.yuls.yspringboot1.entity;

public class Reply extends BaseEntity{


    private Long replyid;
    private Long boardid;
    private String replycontent;
    private int deleteyn;

    public Reply(String regdate, String moddate, String createdby, String modifiedby) {
        super(regdate, moddate, createdby, modifiedby);
    }

    public Reply(String regdate, String moddate, String createdby, String modifiedby, Long replyid, Long boardid, String replycontent, int deleteyn) {
        super(regdate, moddate, createdby, modifiedby);
        this.replyid = replyid;
        this.boardid = boardid;
        this.replycontent = replycontent;
        this.deleteyn = deleteyn;
    }

    public Long getReplyid() {
        return replyid;
    }

    public Long getBoardid() {
        return boardid;
    }

    public String getReplycontent() {
        return replycontent;
    }

    public int getDeleteyn() {
        return deleteyn;
    }
}
