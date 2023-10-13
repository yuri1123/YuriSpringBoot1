package com.yuls.yspringboot1.entity;

public class Board extends BaseEntity{

    private Long id;
    private String subject;
    private String content;


    public Board(String regdate, String moddate, String createdby, String modifiedby) {
        super(regdate, moddate, createdby, modifiedby);
    }

    public Board(String regdate, String moddate, String createdby, String modifiedby, Long id, String subject, String content) {
        super(regdate, moddate, createdby, modifiedby);
        this.id = id;
        this.subject = subject;
        this.content = content;
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

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
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
}
