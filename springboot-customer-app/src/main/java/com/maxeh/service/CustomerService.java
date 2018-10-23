package com.maxeh.service;

import com.maxeh.entity.Customer;

import java.util.List;

public interface CustomerService {
    public Customer addCustomer(Customer customer);

    public Customer getCustomer(Long id);

    public List<Customer> getCustomers();

    public Customer updateCustomer(Customer customer);

    public Long deleteCustomer(Long id);
}
