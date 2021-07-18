package com.spring5.chapter04;

import org.springframework.beans.factory.annotation.Autowired;
import reactor.util.annotation.Nullable;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class MemberPrinter {
    private DateTimeFormatter dateTimeFormatter;

    public MemberPrinter() {
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
    }
    public void print(Member member) {
        if (dateTimeFormatter == null) {
            System.out.printf(
                    "user Info : ID = %d, E-mail = %s, Name = %s, registedTime = %tF\n",
                    member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime()
            );
        }
        else {
            System.out.printf(
                    "user Info : ID = %d, E-mail = %s, Name = %s, registedTime = %s\n",
                    member.getId(), member.getEmail(), member.getName(), dateTimeFormatter.format(member.getRegisterDateTime())
            );
        }
    }

    @Autowired(required = false)
    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }
}
