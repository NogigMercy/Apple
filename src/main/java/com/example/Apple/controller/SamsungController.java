package com.example.Apple.controller;

import com.example.Apple.entity.Apple;
import com.example.Apple.entity.Samsung;
import com.example.Apple.service.SamsungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/samsung")
public class SamsungController {
    @Autowired
    SamsungService samsungService;

    @PostMapping("/create")
    public void createProduct(@RequestBody Samsung samsung) {
        samsungService.createProduct(samsung);
    }
    @GetMapping("/getAll")
    public List<Samsung> getAllProducts() {
        return samsungService.getAllProducts();
    }

    @GetMapping("/get/{id}")
    public Samsung getProductById(@PathVariable Integer id) {
        return samsungService.getProductById(id);
    }

    @GetMapping("/get/byMemory/{memory}")
    private Samsung getProductByMemory(@PathVariable int memory) {
        return samsungService.getProductByMemory(memory);

    }
    @GetMapping("/get/byPrice/{price}")
    private Samsung getProductByPrice(@PathVariable int price) {
        return samsungService.getProductByPrice(price);
    }
    @PutMapping("/update/{id}")
    private Samsung updateProduct(@PathVariable Integer id, @RequestBody Samsung samsung) {
        return samsungService.updateProduct(id, samsung);
    }
    @DeleteMapping("/delete/{id}")
    private void deleteProduct(@PathVariable Integer id) {
        samsungService.deleteProduct(id);
    }

}
