package org.example.SpringMVCTemplate.simpleAuth.entity;

import org.example.SpringMVCTemplate.simpleAuth.dto.UserDto;

import java.util.Date;

public class UserEntity {
    private String id;
    private String pwd;
    private String name;
    private String email;
    private Date birth;
    private String sns;
    private Date reg_date;

    public UserEntity() {}

    public UserEntity(String id, String pwd, String name, String email, Date birth, String sns, Date reg_date) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.sns = sns;
        this.reg_date = reg_date;
    }

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

    public UserDto toDto(UserEntity user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setPwd(user.getPwd());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setBirth(user.getBirth());
        userDto.setSns(user.getSns());
        userDto.setReg_date(user.getReg_date());
        return userDto;
    }
}

