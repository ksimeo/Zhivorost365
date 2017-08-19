package com.ksimeo.nazaru.zhivorost365.service;

import com.ksimeo.nazaru.zhivorost365.domain.models.Product;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ProductServImpl {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/persist-config.xml");
        ctx.refresh();
        ProductService prodServ = ctx.getBean("productService", ProductService.class);
        prodServ.addProduct(new Product());
    }
}
