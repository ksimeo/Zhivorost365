package com.ksimeo.nazaru.zhivorost365.service.impl;

import com.ksimeo.nazaru.zhivorost365.dao.OrderRepository;
import com.ksimeo.nazaru.zhivorost365.domain.models.Order;
import com.ksimeo.nazaru.zhivorost365.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("ordServ")
@Repository
@Transactional
public class OrderServImpl implements OrderService {
    @Autowired
    private OrderRepository ordDao;

    @Override
    public void addOrder(Order ord) {
        ordDao.save(ord);
    }

    @Transactional(readOnly = true)
    @Override
    public Order getOrder(Long id) {
        return ordDao.findOne(id);
    }
    
    @Transactional(readOnly=true)
    @Override
    public List<Order> getAllOrders() {
        return (List<Order>)ordDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Order> getOrdersPage(int pageNumb) {
        return null;
    }

    @Override
    public List<Order> getFreshOrders() {
        return ordDao.getAllNew();
    }
}