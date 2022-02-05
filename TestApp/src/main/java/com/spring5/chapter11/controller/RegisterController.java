package com.spring5.chapter11.controller;

import com.spring5.chapter11.exception.DuplicationMemberException;
import com.spring5.chapter11.model.MemberRegistRequest;
import com.spring5.chapter11.model.RegisterRequest;
import com.spring5.chapter11.service.MemberRegisterService;
import com.spring5.chapter12.controller.RegisterRequestValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private MemberRegisterService memberRegisterService;

    public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }

    @RequestMapping("/step1")
    public String handleStep1() {
        return "register/step1";
    }

    @PostMapping("/step2")
    public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agreeVal, @ModelAttribute("formData") RegisterRequest registerRequest) {
        if (!agreeVal) {
            return "register/step1";
        }
        return "register/step2";
    }

    @GetMapping("/step2")
    public String handlerStep2Get(@ModelAttribute("memberRegistRequest")MemberRegistRequest memberRegistRequest) {
        String[] favoriteOses = {"윈도우8", "윈도우10"};
        String[] favoriteTools = {"Eclipse", "InteliJ", "VScode"};
        memberRegistRequest.setFavoriteOs(favoriteOses);
        memberRegistRequest.setFavoriteTools(favoriteTools);
        return "register/osCheck";
    }

    @PostMapping("/step3")
    public String handleStep3(@Valid @ModelAttribute("formData") RegisterRequest registerRequest, Errors errors) {
//        // 사용자가 구현한 Validation 사용
//        new RegisterRequestValidator().validate(registerRequest, errors);

        if (errors.hasErrors()) {
            return "register/step2";
        }

        try {
            memberRegisterService.regist(registerRequest);
            return "register/step3";
        } catch (DuplicationMemberException e) {
            errors.rejectValue("email", "duplicate");
            return "register/step2";
        }
    }

//    /**
//     * 컨트롤러 범위의 Validator 설정
//     * @param webDataBinder
//     */
//    @InitBinder
//    protected void initBinder(WebDataBinder webDataBinder) {
//        webDataBinder.setValidator(new RegisterRequestValidator());
//    }
}