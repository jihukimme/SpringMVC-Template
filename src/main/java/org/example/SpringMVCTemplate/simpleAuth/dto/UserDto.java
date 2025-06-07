package org.example.SpringMVCTemplate.simpleAuth.dto;

import org.example.SpringMVCTemplate.simpleAuth.entity.User;

import java.util.Date;

public class UserDto {
    private String id;
    private String pwd;
    private String name;
    private String email;
    private Date birth;
    private String sns;
    private Date reg_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSns() {
        return sns;
    }

    public void setSns(String sns) {
        this.sns = sns;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setPwd(userDto.getPwd());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setBirth(userDto.getBirth());
        user.setSns(userDto.getSns());
        user.setReg_date(userDto.getReg_date());

        return user;
    }
}