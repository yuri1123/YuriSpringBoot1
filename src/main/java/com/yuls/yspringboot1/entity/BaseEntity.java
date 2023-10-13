package com.yuls.yspringboot1.entity;

public class BaseEntity {

    private String regdate;
    private String moddate;
    private String createdby;
    private String modifiedby;

    public BaseEntity(String regdate, String moddate, String createdby, String modifiedby) {
        this.regdate = regdate;
        this.moddate = moddate;
        this.createdby = createdby;
        this.modifiedby = modifiedby;
    }

    public String getRegdate() {
        return regdate;
    }

    public String getModdate() {
        return moddate;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getModifiedby() {
        return modifiedby;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "regdate='" + regdate + '\'' +
                ", moddate='" + moddate + '\'' +
                ", createdby='" + createdby + '\'' +
                ", modifiedby='" + modifiedby + '\'' +
                '}';
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public void setModdate(String moddate) {
        this.moddate = moddate;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public void setModifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }
}
