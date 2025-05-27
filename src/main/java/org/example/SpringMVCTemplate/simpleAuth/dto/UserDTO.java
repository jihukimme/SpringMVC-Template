package org.example.SpringMVCTemplate.simpleAuth.dto;

public class UserDTO {
    public String id;
    public String password;

    // 기본 생성자
    public UserDTO() {

    }

    // 생성자
    public UserDTO(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {return id;}
    public String getPassword() {return password;}

    public void setId(String id) {this.id = id;}
    public void setPassword(String password) {this.password = password;}
}
