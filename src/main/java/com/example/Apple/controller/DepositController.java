package com.example.Apple.controller;

import com.example.Apple.entity.Deposit;
import com.example.Apple.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/deposit")
public class DepositController {
    @Autowired
    DepositService depositService;
    @PostMapping("/create")
    public void createProduct(@RequestBody Deposit deposit) {
        depositService.createProduct(deposit);
    }

    @GetMapping("/get/{id}")
    public Optional<Deposit> getProductById(@PathVariable Integer id) {
        return depositService.getProductById(id);
    }
    @GetMapping("/update/{id}")
    public Deposit updateProductById(@PathVariable Integer id, @RequestBody Deposit deposit){
        return depositService.updateProduct(id,deposit);
    }
    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable Integer id){
         depositService.deleteProduct(id);
    }
}
