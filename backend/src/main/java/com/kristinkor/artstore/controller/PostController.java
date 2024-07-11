package com.kristinkor.artstore.controller;

import com.kristinkor.artstore.model.Customer;
import com.kristinkor.artstore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class PostController{

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customer.setCreatedAt(new Date());
        customer.setUpdatedAt(new Date());
        return customerRepository.save(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customerDetails) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setName(customerDetails.getName());
            customer.setEmail(customerDetails.getEmail());
            customer.setPassword(customerDetails.getPassword());
            customer.setAddressLine1(customerDetails.getAddressLine1());
            customer.setAddressLine2(customerDetails.getAddressLine2());
            customer.setCity(customerDetails.getCity());
            customer.setState(customerDetails.getState());
            customer.setZip(customerDetails.getZip());
            customer.setBillingAddressLine1(customerDetails.getBillingAddressLine1());
            customer.setBillingAddressLine2(customerDetails.getBillingAddressLine2());
            customer.setBillingCity(customerDetails.getBillingCity());
            customer.setBillingState(customerDetails.getBillingState());
            customer.setBillingZip(customerDetails.getBillingZip());
            customer.setPaymentMethod(customerDetails.getPaymentMethod());
            customer.setCardNumber(customerDetails.getCardNumber());
            customer.setCardExpiration(customerDetails.getCardExpiration());
            customer.setCardCVC(customerDetails.getCardCVC());
            customer.setUpdatedAt(new Date());
            return customerRepository.save(customer);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
        customerRepository.deleteById(id);
    }
}
