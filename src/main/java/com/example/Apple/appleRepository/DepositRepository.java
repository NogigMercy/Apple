package com.example.Apple.appleRepository;

import com.example.Apple.entity.Deposit;
import com.example.Apple.entity.Samsung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Integer> {
    Deposit findByName(String name);
    Deposit findByPrice(int price);
    Deposit findByMemory(int memory);
    Deposit findByStock(int stock);
}
