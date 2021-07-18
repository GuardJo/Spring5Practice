package com.spring5.chapter04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collection;

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
