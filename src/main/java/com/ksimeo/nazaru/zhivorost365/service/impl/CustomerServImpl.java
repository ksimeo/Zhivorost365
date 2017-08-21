package com.ksimeo.nazaru.zhivorost365.service.impl;

import com.ksimeo.nazaru.zhivorost365.dao.CustomerRepository;
import com.ksimeo.nazaru.zhivorost365.domain.models.Customer;
import com.ksimeo.nazaru.zhivorost365.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("custServ")
@Repository
@Transactional
public class CustomerServImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    @Override
    public void addCustomer(Customer cust) {
        repository.save(cust);
    }

    @Transactional(readOnly = true)
    @Override
    public Customer getCustomer(String id) {
        return repository.findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Customer> getCustomers() {
        return (List<Customer>) repository.findAll();
    }
}