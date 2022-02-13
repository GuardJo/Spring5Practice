package com.spring5.chapter15.controller;

import com.spring5.chapter11.model.Member;
import com.spring5.chapter11.model.MemberDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberDeleteController {
    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @RequestMapping("members/delete/{id}")
    public String delete(@PathVariable("id") Long memberId, Model model) {
        Member member = memberDao.selectById(memberId);

        if (member == null) {
            return "member/noMember";
        }

        memberDao.delete(memberId);
        model.addAttribute("member", member);
        return "member/memberDelete";
    }
}
