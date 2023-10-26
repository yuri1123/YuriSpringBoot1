package com.yuls.yspringboot1.dto;

public class BoardDto {

    private Long id;
    private String subject;
    private String content;
    private String regdate;
    private String moddate;
    private String createdby;
    private String modifiedby;
    private Integer delete_yn;

    public BoardDto(Long id, String subject, String content, String regdate, String moddate, String createdby, String modifiedby, Integer delete_yn) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.regdate = regdate;
        this.moddate = moddate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
        this.delete_yn = delete_yn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public int getDelete_yn() {
        return delete_yn;
    }

    public void setDelete_yn(int delete_yn) {
        this.delete_yn = delete_yn;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", regdate='" + regdate + '\'' +
                ", moddate='" + moddate + '\'' +
                ", createdby='" + createdby + '\'' +
                ", modifiedby='" + modifiedby + '\'' +
                ", delete_yn=" + delete_yn +
                '}';
    }
}

