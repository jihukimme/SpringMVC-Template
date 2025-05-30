package org.example.SpringMVCTemplate.simpleAuth.service;

import org.example.SpringMVCTemplate.simpleAuth.dto.UserDto;

public interface UserService {
    boolean register(UserDto userDto);

    boolean login(String id, String pwd);

    UserDto getUser(String id);
}