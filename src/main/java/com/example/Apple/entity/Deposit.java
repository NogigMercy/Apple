package com.example.Apple.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Deposit")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // daca ceva schimb identity pe auto
    @Column(name = "id", updatable = false, nullable = false)
    private Integer deviceId;
    private String name;
    private int price;
    private int memory;
    private int stock;


    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
