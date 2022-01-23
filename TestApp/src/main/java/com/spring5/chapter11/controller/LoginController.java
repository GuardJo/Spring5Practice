package com.spring5.chapter11.controller;

import com.spring5.chapter11.model.LoginInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String form(Model model) {
        LoginInfo loginInfo = new LoginInfo();
        List<String> loginTypes = createLoginType();

        loginInfo.setLoginType(loginTypes);

        model.addAttribute("loginInfo", loginInfo);
        return "login/form";
    }

    private List<String> createLoginType() {
        List<String> loginTypes = new ArrayList<>();
        loginTypes.add("일반회원");
        loginTypes.add("기업회원");
        loginTypes.add("헤드헌터회원");

        return loginTypes;
    }
}
