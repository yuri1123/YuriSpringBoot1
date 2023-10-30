package com.yuls.yspringboot1.entity;

public class Board extends BaseEntity {

    private Long id;
    private String subject;
    private String content;
    private int delete_yn;

    private int viewcount;

    public Board(String regdate, String moddate, String createdby, String modifiedby) {
        super(regdate, moddate, createdby, modifiedby);
    }

    public Board(String regdate, String moddate, String createdby, String modifiedby, Long id, String subject, String content, int delete_yn, int viewcount) {
        super(regdate, moddate, createdby, modifiedby);
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.delete_yn = delete_yn;
        this.viewcount = viewcount;
    }

    public int getDelete_yn() {
        return delete_yn;
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDelete_yn(int delete_yn) {
        this.delete_yn = delete_yn;
    }

    public int getViewcount() {
        return viewcount;
    }

    public void setViewcount(int viewcount) {
        this.viewcount = viewcount;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", delete_yn=" + delete_yn +
                ", viewcount=" + viewcount +
                '}';
    }
}
