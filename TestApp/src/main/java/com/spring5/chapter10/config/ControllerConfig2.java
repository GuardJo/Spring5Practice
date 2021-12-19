package com.spring5.chapter10.config;

import com.spring5.chapter10.HelloController2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig2 {
    @Bean
    public HelloController2 helloController2() {
        return new HelloController2();
    }
}
