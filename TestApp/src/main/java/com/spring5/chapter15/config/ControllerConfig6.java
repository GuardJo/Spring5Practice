package com.spring5.chapter15.config;

import com.spring5.chapter11.model.MemberDao;
import com.spring5.chapter15.controller.MemberDeleteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class ControllerConfig6 {
    @Autowired
    private MemberDao memberDao;

    @Bean
    public MemberDeleteController memberDeleteController() {
        MemberDeleteController memberDeleteController = new MemberDeleteController();
        memberDeleteController.setMemberDao(memberDao);

        return memberDeleteController;
    }
}
