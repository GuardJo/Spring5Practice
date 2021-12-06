package com.spring5.chapter08.main;

import com.spring5.chapter08.Member;
import com.spring5.chapter08.MemberDao;
import com.spring5.chapter08.config.DbConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MainForMemberDao {
    private static MemberDao memberDao;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddHHmmss");
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DbConfig.class);

        memberDao = context.getBean(MemberDao.class);

        selectAll();
        updateMember("dagh1218@naver.com");
        insertMember();

        context.close();
    }

    private static void selectAll() {
        System.out.println("Select All");
        int total = memberDao.count();
        System.out.println("Total : " + total);

        List<Member> members = memberDao.selectAll();

        for (Member member : members) {
            System.out.println(member.getId() + " : " + member.getEmail() + " : " + member.getName());
        }
    }

    private static void updateMember(String email) {
        System.out.println("Update Member");
        Member member = memberDao.selectByEmail(email);
        String oldPw = member.getPassword();
        String newPw = Double.toHexString(Math.random());
        member.changePassword(oldPw, newPw);

        memberDao.update(member);
        System.out.println("Change password : " + oldPw + " > " + newPw);
    }

    private static void insertMember() {
        System.out.println("Insert Member");

        String prefix = formatter.format(LocalDateTime.now());

        Member member = new Member(prefix + "@test.com", prefix, prefix, LocalDateTime.now());
        memberDao.insert(member);
        System.out.println(member.getId() + " Insert Data");
    }
}
