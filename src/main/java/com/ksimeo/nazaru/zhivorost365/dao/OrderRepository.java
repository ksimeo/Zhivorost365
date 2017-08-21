package com.ksimeo.nazaru.zhivorost365.dao;

import com.ksimeo.nazaru.zhivorost365.domain.models.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(value = "from Order c where view_date = null")
    List<Order> getAllNew();
}