package org.example.SpringMVCTemplate.simpleAuth.dto;

import java.util.Date;

public class UserDTO {
    private String id;
    private String pwd;
    private String name;
    private String email;
    private Date birth;
    private String sns;

    // getter/setter, toString 등 추가
    public String getId() {
        return id;
    }
    public String getPwd() {
        return pwd;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public Date getBirth() {
        return birth;
    }
    public String getSns() {
        return sns;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }
    public void setSns(String sns) {
        this.sns = sns;
    }
}