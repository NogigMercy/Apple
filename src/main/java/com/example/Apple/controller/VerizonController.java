package com.example.Apple.controller;

import com.example.Apple.entity.Verizon;
import com.example.Apple.service.VerizonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/verizon")
public class VerizonController {
    @Autowired
    VerizonServices verizonServices;

    @PostMapping("/create")
    public void createProduct(@RequestBody Verizon verizon) {
        verizonServices.createProduct(verizon);
    }

    @GetMapping("/getAll")
    public List<Verizon> getAllProducts() {
        return verizonServices.getAllProducts();
    }

    @GetMapping("/get/{id}")
    public Verizon getProductById(@PathVariable Integer id) {
        return verizonServices.getProductById(id);
    }

    @GetMapping("/get/byMemory/{memory}")
    private Verizon getProductByMemory(@PathVariable int memory) {
        return verizonServices.getProductByMemory(memory);
    }


    @GetMapping("/get/byPrice/{price}")
    private Verizon getProductByNumber(@PathVariable int number) {
        return verizonServices.getProductByPrice(number);
    }

    @PutMapping("/update/{id}")
    private Verizon updateProduct(@PathVariable Integer id, @RequestBody Verizon verizon) {
        return verizonServices.updateProduct(id, verizon);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteProduct(@PathVariable Integer id) {
        verizonServices.deleteProduct(id);
    }
}
