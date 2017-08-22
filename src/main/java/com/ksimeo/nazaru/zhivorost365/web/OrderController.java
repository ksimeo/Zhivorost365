package com.ksimeo.nazaru.zhivorost365.web;

import com.ksimeo.nazaru.zhivorost365.domain.dto.OrderDTO;
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
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService ordServ;
    @Autowired
    private ProductService prodServ;

    @RequestMapping(value = "/order/{type}/{amount}")
    public String showOrderForm(Model uiModel,@PathVariable("type") int type,@PathVariable("amount") int amount) {
        logger.info("showOrderForm(): type = {} in amount = {}", type, amount);
        OrderDTO ord = new OrderDTO();
        if (amount != 0 && type != 0) {
            ord.setAmount(amount);
            ord.setType(type);
        }
        List<Product> prods = prodServ.getProducts();
        uiModel.addAttribute("products", prods);
        uiModel.addAttribute("orderForm", ord);
        return "public/order";
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String saveOrder(@Valid Order uiModel, Model model, BindingResult bindingResult, HttpServletRequest req) {
        logger.info("saveOrder(): {}", uiModel);
        HttpSession session = req.getSession();
        Customer cust = (Customer) session.getAttribute("customer");
        uiModel.setCustomer(cust);
        try {
//        ordServ.addOrder(uiModel);
            logger.info("showOrder: {}", "sucssed");
            model.addAttribute("order", uiModel);
            model.addAttribute("css", "success");
            model.addAttribute("msg", "Дякуємо за ваше замовлення! Ми зв'яжемося з вами найближчим часом :)");
            return "public/gratitude";
        } catch (Exception e) {
            logger.error("showOrder: {}", "failure");
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Шкода, але на нашому сервісі виникли негоразди.:(" +
                    " Будь ласка, спробуйте ще раз, пізніше!");
            return "public/gratitude";
        }
    }

    @RequestMapping(value = "/admin/orders")
    public String showFreshOrders(Model model) {
        logger.debug("showFreshOrder()");
        List<Order> orders = ordServ.getFreshOrders();
        model.addAttribute("orders", orders);
        return "private/main";
    }

    @RequestMapping(value = "/admin/orders/history/{page}")
    public String showOrdersHistory(Model model, @PathVariable("page") int pageNumb) {
        logger.debug("showOrdersHistory()");
        List<Order> orders = ordServ.getOrdersPage(pageNumb);
        model.addAttribute("orders", orders);
        return "private/history";
    }
}