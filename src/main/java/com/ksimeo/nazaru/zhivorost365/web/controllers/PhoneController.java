package com.ksimeo.nazaru.zhivorost365.web.controllers;

import com.ksimeo.nazaru.zhivorost365.domain.dto.PhoneDTO;
import com.ksimeo.nazaru.zhivorost365.domain.models.Customer;
import com.ksimeo.nazaru.zhivorost365.service.CustomerService;
import com.ksimeo.nazaru.zhivorost365.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class PhoneController {

    private final Logger logger = LoggerFactory.getLogger(PhoneController.class);
    @Autowired
    private CustomerService custServ;
    @Autowired
    private OrderService ordServ;

    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String showWelcomePage(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if((cookie.getName()).equals("domain") || (cookie.getName()).equals("number")) {
                    req.setAttribute(cookie.getName(), cookie.getValue());
                }
            }
        }
        String usersHost = req.getHeader("host");
        logger.info("user {} has entered on main page", usersHost);
        return "public/index";
    }

    @RequestMapping(value = "/phone", method = RequestMethod.POST)
    public String checkPhoneNumber(@Valid PhoneDTO model, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("Full phone number:" + model.getPhone());
        String phoneNumb = model.getPhone();
        logger.info("Phone number {} has been entered", phoneNumb);
        HttpSession session = req.getSession();
        Customer cust = custServ.getCustomer(phoneNumb);
        String direction;
        if (cust != null) {
            session.setAttribute("customer", cust);
            direction = "redirect:/order";
        } else {
            session.setAttribute("phone", model);
            direction = "redirect:/customer";
        }
        return direction;
    }
}
