package com.spring5.chapter13.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ChangePasswordCommandValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ChangePwdCommand.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPassword", "required");
        ValidationUtils.rejectIfEmpty(errors, "newPassword", "required");
    }
}
