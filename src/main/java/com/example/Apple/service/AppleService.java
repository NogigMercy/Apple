package com.example.Apple.service;

import com.example.Apple.appleRepository.AppleRepository;
import com.example.Apple.config.NotFoundException;
import com.example.Apple.entity.Apple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppleService {
    @Autowired
    AppleRepository appleRepository;

    public Apple createProduct(Apple apple) {
        return appleRepository.save(apple);
    }

    public Apple findById(Integer id) {
        final Optional<Apple> appleOptional = appleRepository.findById(id);
        if (appleOptional.isEmpty()) {
            throw new NotFoundException("The product " + id + " has not been found!");
        }

        return appleOptional.get();
    }

    public List<Apple> getAllProducts() {
        return appleRepository.findAll();
    }

    public Apple getProductByMemory(int memory) {
        final Optional<Apple> appleOptional = Optional.ofNullable(appleRepository.findByMemory(memory));
        if (appleOptional.isEmpty()) {
            throw new NotFoundException("The product " + memory + " has not been found!");
        }
        return appleRepository.findByMemory(memory);
    }

    public Apple getProductByPrice(int price) {
        final Optional<Apple> appleOptional = Optional.ofNullable(appleRepository.findByPrice(price));
        if (appleOptional.isEmpty()) {
            throw new NotFoundException("The product with this " + price + " has not been found!");
        }
        return appleRepository.findByPrice(price);
    }

    public Apple updateProduct(Integer id, Apple apple){
        Apple productToUpdate = findById(id);
        productToUpdate.setName(apple.getName());
        productToUpdate.setMemory(apple.getMemory());
        productToUpdate.setPrice(apple.getPrice());
       return appleRepository.save(productToUpdate);
    }

    public void deleteProductById(Integer id) {
        Optional<Apple> apple = appleRepository.findById(id);
        if (apple.isEmpty()) {
            throw new NotFoundException("Product not found " + id);
        }
        appleRepository.deleteById(id);
    }
}
