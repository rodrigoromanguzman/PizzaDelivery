package com.example.pizzaDelivery.controller;

import com.example.pizzaDelivery.model.Ingredient;
import com.example.pizzaDelivery.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    IngredientRepository ingredientRepo;
    private Map<String,Ingredient> ingredientMap = new HashMap<>();

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepository){
        this.ingredientRepo = ingredientRepository
    }
    @Override
    public Ingredient convert(String id){
        System.out.print("Inside Convert");
        return ingredientRepo.findById(id).orElse(null);
    }

}
