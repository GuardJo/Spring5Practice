package com.spring5.chapter14.controller;

import com.spring5.chapter11.model.Member;
import com.spring5.chapter11.model.MemberDao;
import com.spring5.chapter14.model.ListCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MemberListController {
    private MemberDao memberDao;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @RequestMapping("/members")
    public String list(@ModelAttribute("command")ListCommand listCommand, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "member/memberList";
        }
        if (listCommand.getFrom() != null && listCommand.getTo() != null) {
            List<Member> members = memberDao.selectByRegdate(listCommand.getFrom(), listCommand.getTo());
            model.addAttribute("members", members);
        }

        return "member/memberList";
    }

    @RequestMapping("/members/all")
    public String allList(@ModelAttribute("command")ListCommand listCommand, Model model) {
        List<Member> members = memberDao.selectAll();
        model.addAttribute("members", members);

        return "member/memberList";
    }
}
