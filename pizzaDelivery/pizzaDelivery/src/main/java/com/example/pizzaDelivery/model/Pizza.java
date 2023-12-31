package com.example.pizzaDelivery.model;

import lombok.Data;

import java.util.List;

@Data
public class Pizza {
    private String name;
    private List<Ingredient> ingredients;
}
