package com.ksimeo.nazaru.zhivorost365.service;

import com.ksimeo.nazaru.zhivorost365.domain.models.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer cust);
    Customer getCustomer(int id);
    List<Customer> getCustomers();
}
