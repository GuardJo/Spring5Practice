package com.spring5.chapter11.config;

import com.spring5.chapter11.controller.LoginController;
import com.spring5.chapter11.controller.RegisterController;
import com.spring5.chapter11.controller.SurveyController;
import com.spring5.chapter11.service.MemberRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig3 {
    @Autowired
    MemberRegisterService memberRegisterService;

//    @Bean
//    public HomeController homeController() {
//        return new HomeController();
//    }

    @Bean
    public RegisterController registerController() {
        RegisterController registerController = new RegisterController();
        registerController.setMemberRegisterService(memberRegisterService);
        return registerController;
    }

    @Bean
    public SurveyController surveyController() {
        return new SurveyController();
    }

    @Bean
    public LoginController loginController() {
        return new LoginController();
    }
}
