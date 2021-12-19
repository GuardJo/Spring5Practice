package com.spring5.chapter10;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController2 {
    @GetMapping("/hello2")
    public String hello(Model model, @RequestParam(value = "name", required = false) String name) {
        System.out.println("[Test] test2");
        model.addAttribute("greeting", "안녕하슈 " + name);

        return "hello";
    }
}
