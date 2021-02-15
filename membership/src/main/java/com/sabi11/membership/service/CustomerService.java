package com.sabi11.membership.service;

import com.sabi11.membership.exception.UserNotFoundException;
import com.sabi11.membership.model.Customer;
import com.sabi11.membership.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class CustomerService {

    private final CustomerRepo customerRepo;


    @Autowired
    public CustomerService(CustomerRepo customerRepo)  {
        this.customerRepo = customerRepo;
    }

    public Customer addCustomer(Customer customer) {
        customer.setMembershipCode(UUID.randomUUID().toString());
        return  customerRepo.save(customer);
    }

    public List<Customer> findAllCustomer() {
        return customerRepo.findAll();
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer findCustomerById(Long id) {
        return customerRepo.findCustomerById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void  deleteCustomerById(Long id) {
        customerRepo.deleteCustomerById(id);
    }
}
