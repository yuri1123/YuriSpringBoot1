package com.yuls.yspringboot1.entity;

public class User extends BaseEntity{

    private Long id;
    private String userid;
    private String password;
    private String email;
    private String nickname;

    public User(String regdate, String moddate, String createdby, String modifiedby) {
        super(regdate, moddate, createdby, modifiedby);
    }

    public User(String regdate, String moddate, String createdby, String modifiedby, Long id, String userid, String password, String email, String nickname) {
        super(regdate, moddate, createdby, modifiedby);
        this.id = id;
        this.userid = userid;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
