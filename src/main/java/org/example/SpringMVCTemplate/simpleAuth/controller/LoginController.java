package org.example.SpringMVCTemplate.simpleAuth.controller;

import org.example.SpringMVCTemplate.simpleAuth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired // 생성자를 통한 의존성 주입
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletResponse response) {
        // 1. 세션을 종료
        session.invalidate();

        // 2. 쿠키(세션 ID에 대한)를 종료 -> 세션 ID에 대한 쿠키를 제거할 필요는 없음(이미 서버 세션을 제거했기 때문)
        // 쿠키 삭제 로직
        Cookie cookie = new Cookie("JSESSIONID", null); // 이름이 같은 쿠키를 다시 생성해 덮어쓰는 방식으로 브라우저에 해당 쿠키를 인식시킴(쿠키를 삭제할 때, 쿠키의 value 값은 무의미)
        cookie.setPath("/"); // 원래 쿠키의 path와 일치해야 함
        cookie.setMaxAge(0); // 즉시 만료
        response.addCookie(cookie); // 브라우저에 다시 전송해야 적용됨

        // 3. 홈으로 이동
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(String id, String pwd, String toURL, boolean rememberId,
                        HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

        if (!userService.login(id, pwd)) {
            model.addAttribute("msg", "ID 또는 Password가 잘못되었습니다.");
            // return "redirect:/login";
            // FORWARD가 아닌 redirect URL을 사용하면 URL 파라미터로 노출됨
            return "loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute("id", id);

        if (rememberId) { // 쿠키에 id가 저장되어있는 경우(아이디 기억)
            Cookie cookie = new Cookie("id", id);
            cookie.setPath("/"); // 전체 경로에 대해 유효하게
            cookie.setMaxAge(60 * 10); // 예: 10분간 유지
            response.addCookie(cookie);
        } else {
            // 쿠키 삭제 로직
            Cookie cookie = new Cookie("id", null); // 이름이 같은 쿠키를 다시 생성해 덮어쓰는 방식으로 브라우저에 해당 쿠키를 인식시킴(쿠키를 삭제할 때, 쿠키의 value 값은 무의미)
            cookie.setPath("/");  // 삭제 시도 시 반드시 동일한 path 지정
            cookie.setMaxAge(0); // 즉시 만료
            response.addCookie(cookie); // 브라우저에 다시 전송해야 적용됨
        }

        return "redirect:/";
    }
}

