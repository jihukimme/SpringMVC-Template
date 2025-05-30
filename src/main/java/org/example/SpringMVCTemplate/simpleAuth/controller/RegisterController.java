package org.example.SpringMVCTemplate.simpleAuth.controller;

import org.example.SpringMVCTemplate.simpleAuth.dto.UserDto;
import org.example.SpringMVCTemplate.simpleAuth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String register(@ModelAttribute UserDto userDto, Model model) {
        System.out.println("UserDTO = " + userDto); // @ModelAttribute를 통해 바인딩만 할 뿐, JSP 렌더링에 필요한 model data는 생성하지 않음

        // 회원가입 시도
        boolean success = userService.register(userDto);

        if (success) {
            return "userInfo";
        } else {
            model.addAttribute("errorMsg", "회원가입에 실패했습니다. 다시 시도해주세요.");
            return "registerForm";
        }
    }
}