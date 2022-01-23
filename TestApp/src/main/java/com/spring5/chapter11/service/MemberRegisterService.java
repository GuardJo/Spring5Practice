package com.spring5.chapter11.service;

import com.spring5.chapter11.exception.DuplicationMemberException;
import com.spring5.chapter11.model.Member;
import com.spring5.chapter11.model.MemberDao;
import com.spring5.chapter11.model.RegisterRequest;

import java.time.LocalDateTime;

public class MemberRegisterService {
    private MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public Long regist(RegisterRequest req) {
        Member member = memberDao.selectByEmail(req.getEmail());
        if (member != null) {
            throw new DuplicationMemberException("dup email " + req.getEmail());
        }
        Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
        memberDao.insert(newMember);

        return newMember.getId();
    }
}
