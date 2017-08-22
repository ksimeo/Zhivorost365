package com.ksimeo.nazaru.zhivorost365.web;

import com.ksimeo.nazaru.zhivorost365.domain.models.Product;
import com.ksimeo.nazaru.zhivorost365.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductController {
    private Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService prodServ;

    @RequestMapping(value = "/admin/products")
    public String showProducts(Model uiModel) {
        logger.info("showProducts()");
        List<Product> products = prodServ.getProducts();
        uiModel.addAttribute("products", products);
        return "private/products";
    }

    @RequestMapping(value = "/admin/products/add", method = RequestMethod.GET)
    public String showProductForm(Model uiModel) {
        logger.info("showProductPage()");
        Product product = new Product();
//        List<Product> prods = prodServ.getProducts();
        uiModel.addAttribute("products", product);
        return "private/product";
    }

    @RequestMapping(value = "admin/product/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute Product model) {
        logger.debug("addProduct()");
        prodServ.addProduct(model);
        return "redirect:/admin/products";
    }
}