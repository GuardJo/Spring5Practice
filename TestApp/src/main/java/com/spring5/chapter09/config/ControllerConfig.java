package com.spring5.chapter09.config;

import com.spring5.chapter09.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class ControllerConfig {
    @Bean
    public HelloController helloController() {
        return new HelloController();
    }
}
