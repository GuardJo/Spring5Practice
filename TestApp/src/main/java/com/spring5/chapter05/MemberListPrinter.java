package com.spring5.chapter05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component("listPrinter")
public class MemberListPrinter {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private MemberSummaryPrinter memberPrinter;

    public MemberListPrinter() {
    }

    public void printAll() {
        Collection<Member> members = memberDao.selectAll();
        members.forEach(m -> memberPrinter.print(m));
    }
}
