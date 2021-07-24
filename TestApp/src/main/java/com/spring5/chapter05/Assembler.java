package com.spring5.chapter05;

public class Assembler {
    private MemberDao memberDao;
    private MemberRegisterService regService;
    private ChangepasswordService pwdService;

    public Assembler() {
        this.memberDao = new MemberDao();
        this.regService = new MemberRegisterService();
        this.pwdService = new ChangepasswordService();
        this.pwdService.setMemberDao(memberDao);
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public MemberRegisterService getRegService() {
        return regService;
    }

    public ChangepasswordService getPwdService() {
        return pwdService;
    }
}
