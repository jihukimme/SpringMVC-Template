package org.example.SpringMVCTemplate.simpleAuth.controller;

import org.example.SpringMVCTemplate.simpleAuth.dto.UserDto;
import org.example.SpringMVCTemplate.simpleAuth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/info")
    public String userInfo(HttpSession session, Model model) {
        String id = (String) session.getAttribute("id");

        if (id == null) {
            return "redirect:/login";
        } else {
            UserDto userDto = userService.getUser(id);

            model.addAttribute("userDto", userDto);
            return "userInfo";
        }
    }
}
