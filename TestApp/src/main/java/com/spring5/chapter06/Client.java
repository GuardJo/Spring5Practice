package com.spring5.chapter06;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean, DisposableBean {
    private String host;

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Client.afterPrpoertiesSet() Execution");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Client.destroy() Execution");
    }

    public void send() {
        System.out.println("Client.send() to " + host);
    }
}
