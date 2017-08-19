package com.ksimeo.nazaru.zhivorost365.service;

import org.springframework.context.support.GenericXmlApplicationContext;

public class OrderServiceTest {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/persist-config.xml");
        ctx.refresh();
        OrderService ts = ctx.getBean("orderService", OrderService.class);
//        ts.addTestModel(new TestModel(0, "Бася", 1));

//        OrderService os = ctx.getBean("orderService", OrderService.class);
//        List<Order> orders = os.getAllOrders();
//        for (Order order : orders) {
//            System.out.println(order);
//        }
    }
}