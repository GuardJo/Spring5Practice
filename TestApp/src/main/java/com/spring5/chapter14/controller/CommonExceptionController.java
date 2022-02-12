package com.spring5.chapter14.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.spring5")
public class CommonExceptionController {
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException exception, Model model) {
        model.addAttribute("exception", exception.getMessage());
        return "error/commonException";
    }
}
