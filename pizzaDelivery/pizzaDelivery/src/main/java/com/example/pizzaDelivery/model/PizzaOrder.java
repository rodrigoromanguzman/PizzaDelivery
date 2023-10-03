package com.example.pizzaDelivery.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PizzaOrder {
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String devlieryZip;

    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<Pizza> pizzas= new ArrayList<>();

    public void addPizza(Pizza newPizza){
        this.pizzas.add(newPizza);
    }
}
