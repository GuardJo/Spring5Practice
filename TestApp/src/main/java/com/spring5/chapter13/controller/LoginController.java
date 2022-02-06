package com.spring5.chapter13.controller;

import com.spring5.chapter11.exception.WrongidPasswordException;
import com.spring5.chapter13.model.AuthInfo;
import com.spring5.chapter13.model.LoginCommand;
import com.spring5.chapter13.service.AuthService;
import com.spring5.chapter13.service.LoginCommandValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    private AuthService authService;

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String form(@ModelAttribute("loginCommand") LoginCommand loginCommand,
                       @CookieValue(value="REMEMBER", required=false) Cookie rCookie) {
        if (rCookie != null) {
            loginCommand.setEmail(rCookie.getValue());
            loginCommand.setRememberEmail(true);
        }
        return "login/loginForm";
    }

    @PostMapping
    public String submit(Model model, LoginCommand loginCommand, Errors errors, HttpSession session,
                         HttpServletResponse response) {
        new LoginCommandValidator().validate(loginCommand, errors);

        if (errors.hasErrors()) {
            return "login/loginForm";
        }

        try {
            AuthInfo authInfo = authService.authenticate(
                    loginCommand.getEmail(),
                    loginCommand.getPassword()
            );

            session.setAttribute("authInfo", authInfo);

            model.addAttribute("userName", authInfo.getName());

            Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getEmail());
            rememberCookie.setPath("/");

            if (loginCommand.isRememberEmail()) {
                rememberCookie.setMaxAge(60 * 60 * 24 * 30);
            }
            else {
                rememberCookie.setMaxAge(0);
            }

            response.addCookie(rememberCookie);

            return "login/loginSuccess";
        } catch (WrongidPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "login/loginForm";
        }
    }
}
