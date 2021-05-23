package com.spring5.chapter03;

public class MemberPrinter {
    public void print(Member member) {
        System.out.printf(
                "user Info : ID = %d, E-mail = %s, Name = %s, registedTime = %s\n",
                member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime()
        );
    }
}
