package com.ksimeo.nazaru.zhivorost365.dao;

import com.ksimeo.nazaru.zhivorost365.domain.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
