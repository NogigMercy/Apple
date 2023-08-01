package com.example.Apple.entity;

import com.example.Apple.service.SamsungService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "Samsung")
public class Samsung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // daca ceva schimb identity pe auto
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    private String name;
    private int price;
    private int memory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}
