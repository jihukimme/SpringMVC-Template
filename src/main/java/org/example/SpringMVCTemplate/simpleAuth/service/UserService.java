package org.example.SpringMVCTemplate.simpleAuth.service;

import org.example.SpringMVCTemplate.simpleAuth.dto.UserDTO;
import org.example.SpringMVCTemplate.simpleAuth.entity.User;

public interface UserService {
    boolean register(UserDTO userDto);
    boolean login(String id, String pwd);
    User getUser(String id);
}