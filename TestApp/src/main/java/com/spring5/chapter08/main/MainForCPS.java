package com.spring5.chapter08.main;

import com.spring5.chapter08.ChangePasswordService;
import com.spring5.chapter08.MemberNotFoundException;
import com.spring5.chapter08.WrongidPasswordException;
import com.spring5.chapter08.config.DbConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForCPS {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class);

        ChangePasswordService cps = ctx.getBean(ChangePasswordService.class);

        try {
            cps.changePassword("dagh1218@naver.com", "0x1.bf82ff4d0bd12p-1", "1111");
            System.out.println("Changed pwd");
        } catch (MemberNotFoundException e) {
            System.out.println("Not Found Member");
        } catch (WrongidPasswordException e) {
            System.out.println("Wrong Number to Password");
        }

        ctx.close();
    }
}
