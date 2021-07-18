package com.spring5.chapter04.config;

import com.spring5.chapter03.MemberPrinter;
import com.spring5.chapter04.MemberInfoPrinter2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx2 {
    @Bean
    public MemberPrinter printer() {
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("mprinter")
    public MemberPrinter printer2() {
        return new MemberPrinter();
    }

    @Bean
    public MemberInfoPrinter2 infoPrinter() {
        MemberInfoPrinter2 infoPrinter = new MemberInfoPrinter2();
        return infoPrinter;
    }
}
