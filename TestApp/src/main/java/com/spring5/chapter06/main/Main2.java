package com.spring5.chapter06.main;

import com.spring5.chapter06.Client;
import com.spring5.chapter06.Client2;
import com.spring5.chapter06.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Client2 client2 = ctx.getBean(Client2.class);
        client2.send();

        ctx.close();
    }
}
