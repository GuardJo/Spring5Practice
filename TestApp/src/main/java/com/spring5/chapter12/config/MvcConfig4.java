package com.spring5.chapter12.config;

import com.spring5.chapter12.controller.RegisterRequestValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig4 implements WebMvcConfigurer {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename("messages.label");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }

//    /**
//     * 글로벌 범위 Validator 설정
//     * @return
//     */
//    @Override
//    public Validator getValidator() {
//        return new RegisterRequestValidator();
//    }
}
