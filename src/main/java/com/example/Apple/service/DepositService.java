package com.example.Apple.service;

import com.example.Apple.appleRepository.DepositRepository;
import com.example.Apple.config.NotFoundException;
import com.example.Apple.entity.Deposit;
import com.example.Apple.entity.Samsung;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepositService {
    @Autowired
    DepositRepository depositRepository;

    public Deposit createProduct(Deposit deposit) {
        return depositRepository.save(deposit);
    }

    public List<Deposit> getAllProducts() {
        return depositRepository.findAll();
    }

    public Optional<Deposit> getProductById(Integer id) {
        final Optional <Deposit> depositOptional = depositRepository.findById(id);
        if (depositOptional.isEmpty()) {
            throw new NotFoundException("The product " + id + " has not been found!");
        }
        return depositRepository.findById(id);
    }

    public Deposit updateProduct(Integer id, Deposit deposit) {
        Optional<Deposit> productToUpdateOptional = getProductById(id);

        if (productToUpdateOptional.isPresent()) {
            Deposit productToUpdate = productToUpdateOptional.get();
            productToUpdate.setName(deposit.getName());
            productToUpdate.setMemory(deposit.getMemory());
            productToUpdate.setPrice(deposit.getPrice());
            return depositRepository.save(productToUpdate);
        } else {
            throw new NotFoundException("The product " + id + " has not been found!");
        }
    }
    public void deleteProduct(Integer id){
        Optional<Deposit> productToDelete= getProductById(id);
        if (productToDelete.isEmpty()){
            throw new NotFoundException("The product " + id + " has not been found!");
        }
        depositRepository.deleteById(id);
    }
}
