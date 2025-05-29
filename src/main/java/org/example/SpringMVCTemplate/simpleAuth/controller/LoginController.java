package org.example.SpringMVCTemplate.simpleAuth.controller;

import org.example.SpringMVCTemplate.simpleAuth.repository.UserRepository;
import org.example.SpringMVCTemplate.simpleAuth.entity.User;
import org.example.SpringMVCTemplate.simpleAuth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String loginForm() {return "loginForm";}

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 1. 세션을 종료
        session.invalidate();
        // 2. 홈으로 이동
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(String id, String pwd, String toURL, boolean rememberId,
                        HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (!userService.login(id, pwd)) {
            String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
            return "redirect:/login?msg=" + msg;
        }

        HttpSession session = request.getSession();
        session.setAttribute("id", id);

        if (rememberId) {
            response.addCookie(new Cookie("id", id));
        } else {
            Cookie cookie = new Cookie("id", id);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        toURL = (toURL == null || toURL.isEmpty()) ? "/" : toURL;
        return "redirect:" + toURL;
    }
}

