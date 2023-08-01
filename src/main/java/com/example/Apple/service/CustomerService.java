package com.example.Apple.service;

import com.example.Apple.appleRepository.CustomerRepository;
import com.example.Apple.config.NotFoundException;
import com.example.Apple.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public Customer createCustomer(Customer customer){
//      Customer existingCustomer = customerRepository.findByEmail(customer.getEmail());
////        if (existingCustomer != null){
////            throw new DataIntegrityViolationException("Customer with email " + customer.getEmail() + " already exists.");
////        }
        return customerRepository.save(customer);
    }
    public Customer findCustomerById(Integer customerid) {
        final Optional<Customer> customerOptional = customerRepository.findById(customerid);
        if (customerOptional.isEmpty()) {
            throw new NotFoundException("The customer " + customerid + " has not been found!");
        }
        return customerOptional.get();
    }
//    public Customer findCustomerById2(Integer customerId){
//        final Customer customerOptional = customerRepository.findByCustomer(customerId);
//        return customerOptional.getCustomerId();
//    }

    public Customer updateCustomer(Integer id, Customer customer){
        Customer customerToUpdate = findCustomerById(id);
        if (customerToUpdate==null){
            throw new NotFoundException("The customer " + id + " has not been found!");
        }
        customerToUpdate.setCustomerId(customerToUpdate.getCustomerId());
        customerToUpdate.setFirstName(customerToUpdate.getFirstName());
        customerToUpdate.setLastName(customerToUpdate.getLastName());
        customerToUpdate.setEmail(customerToUpdate.getEmail());
        customerToUpdate.setPhoneNumber(customerToUpdate.getPhoneNumber());
        customerToUpdate.setBalance(customerToUpdate.getBalance());
        return customerRepository.save(customerToUpdate);
    }
    public void deleteCustomer(Integer id){
        Optional<Customer> customerToDelete= customerRepository.findById(id);
        if (customerToDelete==null){
            throw new NotFoundException("The customer " + id + " has not been found!");
        }
        customerRepository.deleteById(id);
    }
}
