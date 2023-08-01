package com.example.Apple.service;

import com.example.Apple.appleRepository.SamsungRepository;
import com.example.Apple.config.NotFoundException;
import com.example.Apple.entity.Apple;
import com.example.Apple.entity.Samsung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SamsungService {
    @Autowired
    SamsungRepository samsungRepository;

    public Samsung createProduct(Samsung samsung) {
        return samsungRepository.save(samsung);
    }

    public List<Samsung> getAllProducts() {
        return samsungRepository.findAll();
    }

    public Samsung getProductById(Integer id) {

        final Optional<Samsung> samsungOptional = samsungRepository.findById(id);
        if (samsungOptional.isEmpty()) {
            throw new NotFoundException("The product " + id + " has not been found!");
        }
        return samsungOptional.get();
    }
    public Samsung getProductByMemory(int memory) {
        final Optional<Samsung> samsungOptional = Optional.ofNullable(samsungRepository.findByMemory(memory));
        if (samsungOptional.isEmpty()) {
            throw new NotFoundException("The product " + memory + " has not been found!");
        }
        return samsungRepository.findByMemory(memory);
    }
    public Samsung getProductByPrice(int price) {
        final Optional<Samsung> samsungOptional = Optional.ofNullable(samsungRepository.findByPrice(price));
        if (samsungOptional.isEmpty()) {
            throw new NotFoundException("The product with this " + price + " has not been found!");
        }
        return samsungRepository.findByPrice(price);
    }
    public Samsung updateProduct(Integer id, Samsung samsung){
        Samsung productToUpdate = getProductById(id);
        productToUpdate.setName(samsung.getName());
        productToUpdate.setMemory(samsung.getMemory());
        productToUpdate.setPrice(samsung.getPrice());
        return samsungRepository.save(productToUpdate);
    }
    public void deleteProduct(Integer id){
        Optional<Samsung> samsung = samsungRepository.findById(id);
        if (samsung.isEmpty()) {
            throw new NotFoundException("Product not found " + id);
        }
        samsungRepository.deleteById(id);
    }
}
