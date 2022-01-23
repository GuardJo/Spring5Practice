package com.spring5.chapter11.controller;

import com.spring5.chapter11.model.MemberRegistRequest;
import com.spring5.chapter11.model.RegisterRequest;
import com.spring5.chapter11.service.MemberRegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private MemberRegisterService memberRegisterService;

    public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }

    @RequestMapping("/step1")
    public String handleStep1() {
        return "register/step1";
    }

    @PostMapping("/step2")
    public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agreeVal, @ModelAttribute("formData") RegisterRequest registerRequest) {
        if (!agreeVal) {
            return "register/step1";
        }
        return "register/step2";
    }

    @GetMapping("/step2")
    public String handlerStep2Get(@ModelAttribute("memberRegistRequest")MemberRegistRequest memberRegistRequest) {
        String[] favoriteOses = {"윈도우8", "윈도우10"};
        String[] favoriteTools = {"Eclipse", "InteliJ", "VScode"};
        memberRegistRequest.setFavoriteOs(favoriteOses);
        memberRegistRequest.setFavoriteTools(favoriteTools);
        return "register/osCheck";
    }

    @PostMapping("/step3")
    public String handleStep3(@ModelAttribute("formData") RegisterRequest registerRequest) {
        try {
            memberRegisterService.regist(registerRequest);
            return "register/step3";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "register/step2";
        }
    }
}