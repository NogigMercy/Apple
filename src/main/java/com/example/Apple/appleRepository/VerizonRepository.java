package com.example.Apple.appleRepository;

import com.example.Apple.entity.Samsung;
import com.example.Apple.entity.Verizon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerizonRepository extends JpaRepository<Verizon, Integer > {
    Verizon findByName(String name);
    Verizon findByPrice(int price);
    Verizon findByMemory(int memory);
    Verizon findByNumber(int number);
}
