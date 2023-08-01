package com.example.Apple.controller;

import com.example.Apple.entity.Customer;
import com.example.Apple.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping("/create")
    public void createProduct(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }

    @GetMapping("/get/{customerId}")
    public Customer getProductById(@PathVariable Integer customerId) {
        return customerService.findCustomerById(customerId);
    }
    @PutMapping("/update/{id}")
    private Customer updateProduct(@PathVariable Integer id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }
    @DeleteMapping("/delete/{id}")
    private void deleteProduct(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
    }
}
