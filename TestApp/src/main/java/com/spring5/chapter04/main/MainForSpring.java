package com.spring5.chapter04.main;

import com.spring5.chapter04.*;
import com.spring5.chapter04.config.AppCtx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForSpring {
    private static ApplicationContext ctx = null;

    public static void main(String[] args) throws IOException {
        ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Enter command : ");
            String command = br.readLine();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("System Exit");
                break;
            }

            if (command.startsWith("new ")) {
                processNewCommand(command.split(" "));
                continue;
            }
            else if (command.startsWith("change ")) {
                processChangeCommand(command.split(" "));
                continue;
            }
            else if (command.equalsIgnoreCase("list")) {
                processListCommand();
                continue;
            }
            else if (command.startsWith("info ")) {
                processInfoCommand(command.split(" "));
                continue;
            }
            else if (command.equalsIgnoreCase("version")) {
                processVersionCommand();
                continue;
            }

            printHelp();
        }

        br.close();
    }

    private static void processVersionCommand() {
        VersionnPrinter versionnPrinter = ctx.getBean("versionnPrinter", VersionnPrinter.class);
        versionnPrinter.print();
    }

    private static void processInfoCommand(String[] s) {
        if (s.length != 2) {
            printHelp();
            return;
        }
        MemberInfoPrinter memberInfoPrinter = ctx.getBean("memberInfoPrinter", MemberInfoPrinter.class);
        memberInfoPrinter.printMemberInfo(s[1]);
    }

    private static void processListCommand() {
        MemberListPrinter memberListPrinter = ctx.getBean("memberListPrinter", MemberListPrinter.class);
        memberListPrinter.printAll();
    }

    private static void printHelp() {
        System.out.println();
        System.out.println("Wrong Command");
        System.out.println("Use Menual of Command");
        System.out.println("new email name pwd confirmPwd");
        System.out.println("change email currentPwd newPwd");
        System.out.println();
    }

    private static void processChangeCommand(String[] s) {
        if (s.length != 4) {
            printHelp();
            return;
        }

        ChangepasswordService changepasswordService = ctx.getBean("changepasswordService", ChangepasswordService.class);

        try {
            changepasswordService.changePassword(s[1], s[2], s[3]);
            System.out.println("Changed Password!");
        } catch (MemberNotFoundException e) {
            System.out.println("This Email is Not registed!");
        } catch (WrongidPasswordException e) {
            System.out.println("Not Equal Email and Password");
        }
    }

    private static void processNewCommand(String[] s) {
        if (s.length != 5) {
            printHelp();
            return;
        }
        MemberRegisterService registerService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
        RegisterRequest request = new RegisterRequest();
        request.setEmail(s[1]);
        request.setName(s[2]);
        request.setPassword(s[3]);
        request.setConfirmPassword(s[4]);

        if (!request.isPasswordEqualToConfirmPassword()) {
            System.out.println("Not Equal Pwd and Confirm Pwd");
            return;
        }

        try {
            registerService.regist(request);
            System.out.println("Registed!");
        } catch (DuplicationMemberException e) {
            System.out.println("This Member is already Registed!");
        }
    }
}
