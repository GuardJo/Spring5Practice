package com.spring5.chapter13.config;

import com.spring5.chapter11.service.ChangePasswordService;
import com.spring5.chapter13.controller.ChangePwdController;
import com.spring5.chapter13.controller.LoginController;
import com.spring5.chapter13.controller.LogoutController;
import com.spring5.chapter13.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig4 {
    @Autowired
    private AuthService authService;
    @Autowired
    private ChangePasswordService changePasswordService;

    @Bean
    public LoginController loginController() {
        LoginController loginController = new LoginController();
        loginController.setAuthService(authService);

        return loginController;
    }

    @Bean
    public LogoutController logoutController() {
        LogoutController logoutController = new LogoutController();

        return logoutController;
    }

    @Bean
    public ChangePwdController changePwdController() {
        ChangePwdController changePwdController = new ChangePwdController();
        changePwdController.setChangePasswordService(changePasswordService);

        return changePwdController;
    }
}
