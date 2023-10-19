package com.example.pizzaDelivery.controller;

import com.example.pizzaDelivery.model.Ingredient;
import com.example.pizzaDelivery.model.Pizza;
import com.example.pizzaDelivery.model.PizzaOrder;
import com.example.pizzaDelivery.repository.IngredientRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Type;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("pizzaOrder")
public class DesignPizzaController {
    private final IngredientRepository ingredientRepo;
    public DesignPizzaController(IngredientRepository ingredientRepository){
        this.ingredientRepo = ingredientRepo;
    }
    @ModelAttribute
    public void addIngredientsToModel(Model model){
        List<Ingredient> ingredients = (List<Ingredient>) ingredientRepo.findAll();
        Ingredient.Type[] types = Ingredient.Type.values();
        for(Ingredient.Type type:types){
            model.addAttribute(
                    type.toString().toLowerCase(),filteredByType(ingredients,type)
            );
        }
    }

    @ModelAttribute(name="pizzaOrder")
    public PizzaOrder order(){
        return new PizzaOrder();
    }

    @ModelAttribute(name="pizza")
    public Pizza pizza(){
        return new Pizza();
    }

    @GetMapping
    public String showDesign(){
        return "design";
    }

    @PostMapping
    public String processPizza(@Valid Pizza pizza, Errors error, @ModelAttribute PizzaOrder pizzaOrder){
        if(error.hasErrors()){
            return "design";
        }
        pizzaOrder.addPizza(pizza);
        log.info("Pizza pizza: {}",pizza);
        return "redirect:/orders/current";
    }

    public Iterable<Ingredient> filteredByType(List<Ingredient> ingredients, Ingredient.Type type){
        return ingredients.stream().filter(
                x->x.getType().equals(type)
        ).collect(Collectors.toList());
    }

}
