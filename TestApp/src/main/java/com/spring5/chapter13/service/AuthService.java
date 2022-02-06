package com.spring5.chapter13.service;

import com.spring5.chapter11.exception.WrongidPasswordException;
import com.spring5.chapter11.model.Member;
import com.spring5.chapter11.model.MemberDao;
import com.spring5.chapter13.model.AuthInfo;

public class AuthService {
    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public AuthInfo authenticate(String email, String password) {
        Member member = memberDao.selectByEmail(email);

        if (member == null) {
            throw new WrongidPasswordException();
        }
        if (!member.matchPasseword(password)) {
            throw new WrongidPasswordException();
        }

        return new AuthInfo(member.getId(), member.getEmail(), member.getName());
    }
}
