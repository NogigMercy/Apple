package com.example.Apple.controller;

import com.example.Apple.entity.Apple;
import com.example.Apple.service.AppleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class AppleController {
    @Autowired
    private AppleService appleService;

    @PostMapping("/create")
    public void createProduct(@RequestBody Apple apple) {
        appleService.createProduct(apple);
    }

    @GetMapping("/get/{id}")
    public Apple getProductById(@PathVariable Integer id) {
        return appleService.findById(id);
    }

    @GetMapping("/get/all")
    private List<Apple> getAllProducts() {
        return appleService.getAllProducts();
    }

    @GetMapping("/get/byMemory/{memory}")
    private Apple getProductByMemory(@PathVariable int memory) {
        return appleService.getProductByMemory(memory);
        //TODO what will be if i will search for products with same memory capacity
    }

    @GetMapping("/get/byPrice/{price}")
    private Apple getProductByPrice(@PathVariable int price) {
        return appleService.getProductByPrice(price);
    }

    @PutMapping("/update/{id}")
    private Apple updateProduct(@PathVariable Integer id, @RequestBody Apple apple) {
        return appleService.updateProduct(id, apple);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteProduct(@PathVariable Integer id) {
        appleService.deleteProductById(id);
    }
}
