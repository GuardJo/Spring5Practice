package com.spring5.chapter14.config;

import com.spring5.chapter11.model.MemberDao;
import com.spring5.chapter14.controller.CommonExceptionController;
import com.spring5.chapter14.controller.MemberDetailController;
import com.spring5.chapter14.controller.MemberListController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig5 {
    @Autowired
    private MemberDao memberDao;

    @Bean
    public MemberListController memberListController() {
        MemberListController memberListController = new MemberListController();
        memberListController.setMemberDao(memberDao);

        return memberListController;
    }

    @Bean
    public MemberDetailController memberDetailController() {
        MemberDetailController memberDetailController = new MemberDetailController();
        memberDetailController.setMemberDao(memberDao);

        return memberDetailController;
    }

    @Bean
    public CommonExceptionController commonExceptionController() {
        CommonExceptionController commonExceptionController = new CommonExceptionController();

        return commonExceptionController;
    }
}
