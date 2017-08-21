package com.ksimeo.nazaru.zhivorost365.dao;

import com.ksimeo.nazaru.zhivorost365.domain.models.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, String> {

}
