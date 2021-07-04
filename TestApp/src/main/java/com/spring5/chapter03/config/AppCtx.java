package com.spring5.chapter03.config;

import com.spring5.chapter03.*;
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
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangepasswordService changepasswordService() {
        ChangepasswordService changepasswordService = new ChangepasswordService();
        changepasswordService.setMemberDao(memberDao());
        return changepasswordService;
    }

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter memberListPrinter() {
        return new MemberListPrinter(memberDao(), memberPrinter());
    }

    @Bean
    public MemberInfoPrinter memberInfoPrinter() {
        MemberInfoPrinter memberInfoPrinter = new MemberInfoPrinter();
        // AutoWried
//        memberInfoPrinter.setMemberPrinter(memberPrinter());
//        memberInfoPrinter.setMemberDao(memberDao());
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
