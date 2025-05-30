package org.example.SpringMVCTemplate.simpleAuth.service.impl;

import org.example.SpringMVCTemplate.simpleAuth.dao.UserDao;
import org.example.SpringMVCTemplate.simpleAuth.dto.UserDto;
import org.example.SpringMVCTemplate.simpleAuth.entity.UserEntity;
import org.example.SpringMVCTemplate.simpleAuth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public boolean register(UserDto userDto) {
        UserEntity user = userDto.toEntity(userDto);

        return userDao.insertUser(user) > 0;
    }

    @Override
    public boolean login(String id, String pwd) {
        UserEntity user = userDao.selectUser(id);
        return user != null && user.getPwd().equals(pwd);
    }

    @Override
    public UserDto getUser(String id) {
        UserEntity user = userDao.selectUser(id);
        UserDto userDto = user.toDto(user);

        return userDto;
    }
}
