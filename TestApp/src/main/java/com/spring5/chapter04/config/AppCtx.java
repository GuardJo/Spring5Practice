package com.spring5.chapter04.config;

import com.spring5.chapter04.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public MemberRegisterService memberRegisterService() {
        return new MemberRegisterService();
    }

    @Bean
    public ChangepasswordService changepasswordService() {
        ChangepasswordService changepasswordService = new ChangepasswordService();
        return changepasswordService;
    }

//    @Bean
//    public MemberPrinter memberPrinter() {
//        return new MemberPrinter();
//    }

    @Bean
    @Qualifier("printer")
    public MemberPrinter memberPrinter1() {
        return new MemberPrinter();
    }

    @Bean
    public MemberSummaryPrinter memberPrinter2() {
        return new MemberSummaryPrinter();
    }


    @Bean
    public MemberListPrinter memberListPrinter() {
        return new MemberListPrinter();
    }

    @Bean
    public MemberInfoPrinter memberInfoPrinter() {
        MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
        memberInfoPrinter.setMemberPrinter(memberPrinter2());
        return memberInfoPrinter;
    }

    @Bean
    public VersionnPrinter versionnPrinter() {
        VersionnPrinter versionnPrinter = new VersionnPrinter();
        versionnPrinter.setMajorVersion(5);
        versionnPrinter.setMinorVersion(0);

        return versionnPrinter;
    }
}
