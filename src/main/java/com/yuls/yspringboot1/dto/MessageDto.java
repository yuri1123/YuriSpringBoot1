package com.yuls.yspringboot1.dto;

import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

public class MessageDto {

    String message = "";
    String href = "";

    public MessageDto(String message, String href) {
        this.message = message;
        this.href = href;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "message='" + message + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
