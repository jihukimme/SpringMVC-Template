package org.example.SpringMVCTemplate.simpleAuth.controller;

import org.example.SpringMVCTemplate.simpleAuth.dto.UserDTO;
import org.example.SpringMVCTemplate.simpleAuth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserService userService;

    @InitBinder
    public void toDate(WebDataBinder binder) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
    }

    @GetMapping("/add")
    public String registerForm() {
        return "registerForm";
    }

    @PostMapping("/add")
    public String register(@ModelAttribute UserDTO userDto, BindingResult result, Model model) {
        System.out.println("BindingResult = " + result);
        System.out.println("UserDTO = " + userDto);

        // 유효성 검사 실패 시 다시 폼 보여주기
        if (result.hasErrors()) {
            return "registerForm";
        }

        // 회원가입 시도
        boolean success = userService.register(userDto);

        if (success) {
            return "registerInfo";
        } else {
            model.addAttribute("errorMsg", "회원가입에 실패했습니다. 다시 시도해주세요.");
            return "registerForm";
        }
    }
}