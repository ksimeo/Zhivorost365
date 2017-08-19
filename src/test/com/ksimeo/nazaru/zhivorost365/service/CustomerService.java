package com.ksimeo.nazaru.zhivorost365.service;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomerService {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/persist-config.xml");
        ctx.refresh();
    }
}
