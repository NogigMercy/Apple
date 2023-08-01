package com.example.Apple.appleRepository;

import com.example.Apple.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByFirstName (String fistName);
    List<Customer> findAll();
    Customer findByEmail(String email);
//    Customer findByCustomer(Integer customerId);
}
