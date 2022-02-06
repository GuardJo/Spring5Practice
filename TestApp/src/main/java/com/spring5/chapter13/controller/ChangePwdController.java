package com.spring5.chapter13.controller;

import com.spring5.chapter11.exception.WrongidPasswordException;
import com.spring5.chapter11.service.ChangePasswordService;
import com.spring5.chapter13.model.AuthInfo;
import com.spring5.chapter13.model.ChangePasswordCommandValidator;
import com.spring5.chapter13.model.ChangePwdCommand;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {
    private ChangePasswordService changePasswordService;

    public void setChangePasswordService(ChangePasswordService changePasswordService) {
        this.changePasswordService = changePasswordService;
    }

    @GetMapping
    public String form(@ModelAttribute("changePwd")ChangePwdCommand changePwdCommand, HttpSession session) {
//        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
//        if (authInfo == null) {
//            return "redirect:/login";
//        }
        return "edit/changePwdForm";
    }

    @PostMapping
    public String submit(@ModelAttribute("changePwd")ChangePwdCommand changePwdCommand, Errors errors,
                         HttpSession session) {
        new ChangePasswordCommandValidator().validate(changePwdCommand, errors);

        if (errors.hasErrors()) {
            return "edit/changePwdForm";
        }

        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

        try {
            changePasswordService.changePassword(authInfo.getEmail(), changePwdCommand.getCurrentPassword(),
                    changePwdCommand.getNewPassword());
            return "edit/changePwd";
        } catch (WrongidPasswordException e) {
            errors.rejectValue("currentPassword", "notMatching");
            return "edit/changePwdForm";
        }
    }
}
