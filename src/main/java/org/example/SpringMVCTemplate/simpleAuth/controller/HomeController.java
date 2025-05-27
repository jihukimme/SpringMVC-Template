package org.example.SpringMVCTemplate.simpleAuth.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.example.SpringMVCTemplate.simpleAuth.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model, HttpSession session) {
        // 서버 시간
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("serverTime", formattedDate );

        // 세션에서 UserDTO 꺼내기
        UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);

        return "home";
    }
}