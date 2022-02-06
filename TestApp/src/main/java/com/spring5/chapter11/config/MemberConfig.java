package com.spring5.chapter11.config;

import com.spring5.chapter11.model.LoginInfo;
import com.spring5.chapter11.model.Member;
import com.spring5.chapter11.model.MemberRegistRequest;
import com.spring5.chapter11.service.ChangePasswordService;
import com.spring5.chapter11.model.MemberDao;
import com.spring5.chapter11.service.MemberRegisterService;
import com.spring5.chapter13.service.AuthService;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class MemberConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        // DataSource 객체 생성
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/spring5fs?characterEncoding=utf8");
        ds.setUsername("root");
        ds.setPassword("wh8598286");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setTestWhileIdle(true);
        ds.setMinEvictableIdleTimeMillis(60000 * 3);
        ds.setTimeBetweenEvictionRunsMillis(10 * 1000);

        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());

        return tm;
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }

    @Bean
    public MemberRegisterService memberRegSvc() {
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangePasswordService changePwdSvc() {
        ChangePasswordService pwdSvc = new ChangePasswordService();
        pwdSvc.setMemberDao(memberDao());

        return pwdSvc;
    }

    @Bean
    public LoginInfo loginInfo() {
        LoginInfo loginInfo = new LoginInfo();

        return loginInfo;
    }

    @Bean
    public MemberRegistRequest memberRegistRequest() {
        MemberRegistRequest memberRegistRequest = new MemberRegistRequest();

        return memberRegistRequest;
    }

    @Bean
    public AuthService authService() {
        AuthService authService = new AuthService();
        authService.setMemberDao(memberDao());

        return authService;
    }
}
