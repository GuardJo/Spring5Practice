package com.spring5.chapter08.config;

import com.spring5.chapter08.ChangePasswordService;
import com.spring5.chapter08.MemberDao;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DbConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        // DataSource 객체 생성
        DataSource ds = new DataSource();
        
        // JDBC 드라이버 클래스 지정
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        
        // JDBC URL 지정
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/spring5fs?characterEncoding=utf8");
        
        // DB에 연결할 때 사용할 사용자 계정과 암호 지정
        ds.setUsername("root");
        ds.setPassword("wh8598286");
        ds.setInitialSize(2);
        ds.setMaxActive(10);

        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());

        return dataSourceTransactionManager;
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }

    @Bean
    public ChangePasswordService changePasswordService() {
        ChangePasswordService changePasswordService = new ChangePasswordService();
        changePasswordService.setMemberDao(memberDao());

        return changePasswordService;
    }
}
