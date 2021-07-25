package com.spring5.chapter06;

public class Client2 {
    private String host;

    public void setHost(String host) {
        this.host = host;
    }

    public void connect() {
        System.out.println("Client2.connect() Execution");
    }

    public void send() {
        System.out.println("Client2.send() Execution");
    }

    public void close() {
        System.out.println("Client2.close() Execution");
    }
}
