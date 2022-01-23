package com.spring5.chapter11.service;

import com.spring5.chapter11.exception.MemberNotFoundException;
import com.spring5.chapter11.model.Member;
import com.spring5.chapter11.model.MemberDao;
import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {
    private MemberDao memberDao;

    @Transactional
    public void changePassword(String email, String oldPwd, String newPwd) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            throw new MemberNotFoundException();
        }
        member.changePassword(oldPwd, newPwd);

        memberDao.update(member);
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
}
