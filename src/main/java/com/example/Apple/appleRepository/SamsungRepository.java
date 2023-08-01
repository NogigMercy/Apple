package com.example.Apple.appleRepository;
import com.example.Apple.entity.Samsung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SamsungRepository extends JpaRepository<Samsung, Integer> {
    Samsung findByName(String name);
    Samsung findByPrice(int price);
    Samsung findByMemory(int memory);
}
