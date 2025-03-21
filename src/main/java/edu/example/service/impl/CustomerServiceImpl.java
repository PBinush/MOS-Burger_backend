package edu.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.example.entity.CustomerEntity;
import edu.example.model.Customer;
import edu.example.repository.CustomerRepository;
import edu.example.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    final CustomerRepository customerRepository;
    final ObjectMapper map;

    @Override
    public boolean saveCustomer(Customer customer) {
        if (customer == null){
            return false;
        }

        try {
            CustomerEntity customerEntity = map.convertValue(customer,CustomerEntity.class);
            customerRepository.save(customerEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        if (customer == null){
            return false;
        }

        try {
            CustomerEntity customerEntity = map.convertValue(customer,CustomerEntity.class);
            customerRepository.save(customerEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(String id) {
        if (id == null || id.isEmpty()){
            return false;
        }
        customerRepository.deleteById(id);
        return !customerRepository.existsById(id);
    }

    @Override
    public Customer getCustomerById(String id) {
        if (id == null || id.isEmpty()){
            return null;
        }

        return map.convertValue(customerRepository.findById(id), Customer.class);
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll()
                .stream()
                .map(customerEntity -> map.convertValue(customerEntity, Customer.class))
                .collect(Collectors.toList());
        if (customerList.isEmpty()){
            return null;
        }else {
            return customerList;
        }

    }
}
