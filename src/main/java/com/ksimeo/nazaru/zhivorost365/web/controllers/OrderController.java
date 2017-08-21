package com.ksimeo.nazaru.zhivorost365.web.controllers;

import com.ksimeo.nazaru.zhivorost365.domain.models.Customer;
import com.ksimeo.nazaru.zhivorost365.domain.models.Order;
import com.ksimeo.nazaru.zhivorost365.domain.models.Product;
import com.ksimeo.nazaru.zhivorost365.service.OrderService;
import com.ksimeo.nazaru.zhivorost365.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService ordServ;
    @Autowired
    private ProductService prodServ;

    @RequestMapping(value = "/{amount}/{type}")
    public String showOrderForm(@PathVariable("amount") int amount, @PathVariable("type") int type, Model uiModel) {
        if (amount != 0 && type != 0) {
            logger.info("They are going to order product type = {} in amount = {},  ", type, amount);
            uiModel.addAttribute(amount);
            uiModel.addAttribute(type);
        }
        List<Product> prods = prodServ.getProducts();
        uiModel.addAttribute("products", prods);
        return "public/order";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrder(@Valid Order uiModel, BindingResult bindingResult, HttpServletRequest req) {
        logger.info("They have done order: {}", uiModel);
        HttpSession session = req.getSession();
        Customer cust = (Customer) session.getAttribute("customer");
        uiModel.setCustomer(cust);
        ordServ.addOrder(uiModel);
        return "public/gratitude";
    }
}