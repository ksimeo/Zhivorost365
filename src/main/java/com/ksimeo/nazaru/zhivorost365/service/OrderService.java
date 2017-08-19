package com.ksimeo.nazaru.zhivorost365.service;

import com.ksimeo.nazaru.zhivorost365.domain.models.Order;

import java.util.List;

public interface OrderService {

    void addOrder(Order ordr);
    Order getOrder(Long id);
    List<Order> getAllOrders();
    List<Order> getOrdersPage(int pageNumb);
}
