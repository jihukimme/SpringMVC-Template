package org.example.SpringMVCTemplate.simpleAuth.service.impl;

import org.example.SpringMVCTemplate.simpleAuth.dto.UserDTO;
import org.example.SpringMVCTemplate.simpleAuth.entity.User;
import org.example.SpringMVCTemplate.simpleAuth.repository.UserRepository;
import org.example.SpringMVCTemplate.simpleAuth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean register(UserDTO userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setPwd(userDto.getPwd());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setBirth(userDto.getBirth());
        user.setSns(userDto.getSns());

        return userRepository.insertUser(user) > 0;
    }

    @Override
    public boolean login(String id, String pwd) {
        User user = userRepository.selectUser(id);
        return user != null && user.getPwd().equals(pwd);
    }

    @Override
    public User getUser(String id) {
        return userRepository.selectUser(id);
    }
}
