package com.spring5.chapter11.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring5.chapter11.exception.WrongidPasswordException;

import java.time.LocalDateTime;

public class Member {
    private Long id;
    private String email;
    @JsonIgnore
    private String password;
    private String name;
//    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonFormat(pattern = "yyyyMMdd HHmmss")
    private LocalDateTime registerDateTime;

    public Member(String email, String password, String name, LocalDateTime regDateTime) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.registerDateTime = regDateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getRegisterDateTime() {
        return registerDateTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegisterDateTime(LocalDateTime registerDateTime) {
        this.registerDateTime = registerDateTime;
    }

    public Long getId() {
        return this.id;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (!password.equals(oldPassword)) {
            throw new WrongidPasswordException();
        }
        else {
            this.password = newPassword;
        }
    }

    /**
     * 패스워드 일치 여부 확인
     * @param password
     * @return
     */
    public boolean matchPasseword(String password) {
        return this.password.equals(password);
    }
}
