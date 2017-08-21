package com.ksimeo.nazaru.zhivorost365.web.controllers;

import com.ksimeo.nazaru.zhivorost365.domain.models.Product;
import com.ksimeo.nazaru.zhivorost365.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    private Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService prodServ;

    public String showProducts(Model uiModel) {
        logger.info("showProducts()");
        List<Product> products = prodServ.getProducts();
        uiModel.addAttribute(products);
        return "admin/products";
    }
}
