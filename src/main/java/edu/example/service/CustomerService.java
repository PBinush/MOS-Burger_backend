package edu.example.service;

import edu.example.model.Customer;

import java.util.List;

public interface CustomerService {
    boolean saveCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(String id);
    Customer getCustomerById(String id);
    List<Customer> getAllCustomers();
}
