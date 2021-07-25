package com.spring5.chapter07;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcut {
    @Pointcut("execution(public * com.spring5.chapter07..*.*(*))")
    public void commonTarget() {

    }
}
