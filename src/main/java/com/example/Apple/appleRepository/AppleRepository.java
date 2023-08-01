package com.example.Apple.appleRepository;

import com.example.Apple.entity.Apple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppleRepository extends JpaRepository<Apple, Integer> {
    Apple findByName(String name);
    Apple findByPrice(int price);
    Apple findByMemory(int memory);
}
