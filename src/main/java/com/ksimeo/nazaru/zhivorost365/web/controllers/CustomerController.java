package com.ksimeo.nazaru.zhivorost365.web.controllers;

import com.ksimeo.nazaru.zhivorost365.domain.dto.PhoneDTO;
import com.ksimeo.nazaru.zhivorost365.domain.models.Customer;
import com.ksimeo.nazaru.zhivorost365.service.CustomerService;
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
@RequestMapping(value = "/customer")
public class CustomerController {

    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService custServ;

    @RequestMapping
    public String showCustomerForm() {
        return "public/customer";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveCustomer(@Valid Customer model, BindingResult bindingResult, HttpServletRequest req,
                               HttpServletResponse resp) {
        HttpSession session = req.getSession();
        PhoneDTO phone = (PhoneDTO) session.getAttribute("phone");
        model.setPhoneNumber(phone.getPhone());
        session.setAttribute("customer", model);
        Cookie cookie1 = new Cookie("domain", phone.getDomain());
        cookie1.setMaxAge(2*7*3600);
        cookie1.setPath("/");
        resp.addCookie(cookie1);
        Cookie cookie2 = new Cookie("number", phone.getNumber());
        cookie2.setPath("/");
        cookie2.setMaxAge(2*7*3600);
        resp.addCookie(cookie2);
        session.setAttribute("customer", model);
        return "redirect:/calc";
    }
}
