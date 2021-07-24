package com.spring5.chapter04;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter2 {

    @Autowired(required = false)
    private MemberPrinter printer;
}
