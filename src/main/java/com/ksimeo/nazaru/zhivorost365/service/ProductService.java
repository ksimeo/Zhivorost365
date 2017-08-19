package com.ksimeo.nazaru.zhivorost365.service;

import com.ksimeo.nazaru.zhivorost365.domain.models.Product;

import java.util.List;

public interface ProductService {

    void addProduct(Product prod);
    Product getProduct(int id);
    List<Product> getProducts();
}
