package org.example.SpringMVCTemplate.simpleAuth.controller;

import org.example.SpringMVCTemplate.simpleAuth.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "loginForm";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute UserDTO userDTO, Model model, HttpSession session) {
        String id = userDTO.getId();
        String password = userDTO.getPassword();

        // 예시: 계정이 admin / 비밀번호 1234 일 때만 로그인 성공 처리
        if ("admin".equals(id) && "1234".equals(password)) {
            session.setAttribute("loginUser", userDTO);
            return "redirect:/"; // 로그인 성공 → 홈으로 리다이렉트
        } else {
            model.addAttribute("errorMsg", "아이디 또는 비밀번호가 틀렸습니다");
            return "loginForm"; // 실패 → 로그인 폼 다시 보여주기
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return "redirect:/loginForm"; // 로그인 페이지로 이동
    }
}
