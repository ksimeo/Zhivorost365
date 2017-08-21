package com.ksimeo.nazaru.zhivorost365.service;

import com.ksimeo.nazaru.zhivorost365.domain.models.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer cust);
    Customer getCustomer(String id);
    List<Customer> getCustomers();
}
