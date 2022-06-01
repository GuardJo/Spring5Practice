package com.spring5.chapter16.config;

import com.spring5.chapter11.model.MemberDao;
import com.spring5.chapter11.service.MemberRegisterService;
import com.spring5.chapter16.controller.RestMemberController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberRegisterService memberRegisterService;

    @Bean
    public RestMemberController restMemberController() {
        RestMemberController restMemberController = new RestMemberController();
        restMemberController.setMemberDao(memberDao);
        restMemberController.setMemberRegisterService(memberRegisterService);

        return restMemberController;
    }
}
