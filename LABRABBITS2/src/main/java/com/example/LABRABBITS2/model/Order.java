package com.example.LABRABBITS2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String meal;
    private String status;

    // Construtor padrão
    public Order() {}

    // Construtor com todos os parâmetros (exceto o ID, que é gerado automaticamente)
    public Order(String meal, String status) {
        this.meal = meal;
        this.status = status;
    }

    // Construtor com ID, caso seja necessário para testes ou outras funções
    public Order(Long id, String meal, String status) {
        this.id = id;
        this.meal = meal;
        this.status = status;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}