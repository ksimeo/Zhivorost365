package com.ksimeo.nazaru.zhivorost365.web;

import com.ksimeo.nazaru.zhivorost365.domain.models.Order;
import com.ksimeo.nazaru.zhivorost365.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private final Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private OrderService ordServ;

    @RequestMapping
    public String showMainPage(Model uiModel) {
        List<Order> orders = ordServ.getFreshOrders();
        uiModel.addAttribute(orders);
        return "admin/main";
    }
}