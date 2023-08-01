package com.example.Apple.service;

import com.example.Apple.appleRepository.VerizonRepository;
import com.example.Apple.config.NotFoundException;
import com.example.Apple.entity.Verizon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VerizonServices {
    @Autowired
    VerizonRepository verizonRepository;

    public Verizon createProduct(Verizon verizon) {
        return verizonRepository.save(verizon);
    }

    public List<Verizon> getAllProducts() {
        return verizonRepository.findAll();
    }

    public Verizon getProductById(Integer id) {

        final Optional<Verizon> verizonOptional = verizonRepository.findById(id);
        if (verizonOptional.isEmpty()) {
            throw new NotFoundException("The product " + id + " has not been found!");
        }
        return verizonOptional.get();
    }

    public Verizon getProductByMemory(int memory) {
        final Optional<Verizon> verizonOptional = Optional.ofNullable(verizonRepository.findByMemory(memory));
        if (verizonOptional.isEmpty()) {
            throw new NotFoundException("The product " + memory + " has not been found!");
        }
        return verizonRepository.findByMemory(memory);
    }

    public Verizon getProductByPrice(int price) {
        final Optional<Verizon> verizonOptional = Optional.ofNullable(verizonRepository.findByPrice(price));
        if (verizonOptional.isEmpty()) {
            throw new NotFoundException("The product " + price + " has not been found!");
        }
        return verizonRepository.findByPrice(price);
    }

    public Verizon getProductByNumber(int number) {
        final Optional<Verizon> verizonOptional = Optional.ofNullable(verizonRepository.findByNumber(number));
        if (verizonOptional.isEmpty()) {
            throw new NotFoundException("The product " + number + " has not been found!");
        }
        return verizonRepository.findByNumber(number);
    }

    public Verizon updateProduct(Integer id, Verizon verizon){
        Verizon productToUpdate = getProductById(id);
        productToUpdate.setName(verizon.getName());
        productToUpdate.setMemory(verizon.getMemory());
        productToUpdate.setPrice(verizon.getPrice());
        return verizonRepository.save(productToUpdate);
    }
    public void deleteProduct(Integer id){
        Optional<Verizon> verizon = verizonRepository.findById(id);
        if (verizon.isEmpty()) {
            throw new NotFoundException("Product not found " + id);
        }
        verizonRepository.deleteById(id);
    }
}
