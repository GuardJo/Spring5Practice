package com.spring5.chapter16.controller;

import com.spring5.chapter11.exception.DuplicationMemberException;
import com.spring5.chapter11.exception.MemberNotFoundException;
import com.spring5.chapter11.model.Member;
import com.spring5.chapter11.model.MemberDao;
import com.spring5.chapter11.model.RegisterRequest;
import com.spring5.chapter11.service.MemberRegisterService;
import com.spring5.chapter12.controller.RegisterRequestValidator;
import com.spring5.chapter16.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/members")
public class RestMemberController {
    private final static Logger log = LoggerFactory.getLogger(RestMemberController.class);
    private MemberDao memberDao;
    private MemberRegisterService memberRegisterService;

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }

    @GetMapping
    public List<Member> members() {
        return memberDao.selectAll();
    }

    @PostMapping
    public ResponseEntity<Object> newMember(@RequestBody @Valid RegisterRequest registerRequest, Errors errors) throws IOException {
        try {
            if (errors.hasErrors()) {
                String errorCodes = errors.getAllErrors()
                        .stream()
                        .map(error -> error.getCodes()[0])
                        .collect(Collectors.joining(","));
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("errorCodes = " + errorCodes));
            }

            Long newMemberId = memberRegisterService.regist(registerRequest);
            URI uri = URI.create("/api/members/" + newMemberId);
            return ResponseEntity.created(uri).build();
        }
        catch (DuplicationMemberException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping("/{id}")
    public Member member(@PathVariable("id") Long memberId) {
        Member member = memberDao.selectById(memberId);

        if (member == null) {
            log.warn("[Test] Not Found Exception");
            throw new MemberNotFoundException();
        }

        return member;
    }
}
