package com.spring5.chapter04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForAssebler {
    private static Assembler assembler = new Assembler();

    public static void main(String[] args) throws IOException {
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

            printHelp();
        }

        br.close();
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
        ChangepasswordService changepasswordService = assembler.getPwdService();

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
        MemberRegisterService registerService = assembler.getRegService();
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
