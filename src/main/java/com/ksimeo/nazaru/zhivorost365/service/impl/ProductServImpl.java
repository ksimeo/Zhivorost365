package com.ksimeo.nazaru.zhivorost365.service.impl;

import com.ksimeo.nazaru.zhivorost365.dao.ProductRepository;
import com.ksimeo.nazaru.zhivorost365.domain.models.Product;
import com.ksimeo.nazaru.zhivorost365.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("prodServ")
@Repository
@Transactional
public class ProductServImpl implements ProductService {
    @Autowired
    private ProductRepository prodDao;

    @Override
    public void addProduct(Product prod) {
        prodDao.save(prod);
    }

    @Override
    public Product getProduct(int id) {
        return prodDao.findOne(id);
    }

    @Override
    public List<Product> getProducts() {
        return (List<Product>)prodDao.findAll();
    }
}
