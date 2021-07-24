package com.spring5.chapter05.config;

import com.spring5.chapter05.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"com.spring5.chapter05"},
        excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE,
                classes = MemberDao.class))
public class AppCtxWithExclude {

    @Bean
    @Qualifier("printer2")
    public MemberPrinter memberPrinter1() {
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("summaryPrinter")
    public MemberSummaryPrinter memberPrinter2() {
        return new MemberSummaryPrinter();
    }

    @Bean
    public VersionnPrinter versionnPrinter() {
        VersionnPrinter versionnPrinter = new VersionnPrinter();
        versionnPrinter.setMajorVersion(5);
        versionnPrinter.setMinorVersion(0);

        return versionnPrinter;
    }
}
