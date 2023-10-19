package com.example.pizzaDelivery.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Pizza {
    private Long id;
    private Date createdAt = new Date();
    @NotNull
    @Size(min=5,message = "Escribe por lo menos 5 caracteres")
    private String name;
    @NotNull
    @Size(min=1,message = "Elegir por lo menos un ingrediente")
    private List<Ingredient> ingredients;
}



