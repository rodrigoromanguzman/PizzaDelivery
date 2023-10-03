package com.example.pizzaDelivery.controller;

import com.example.pizzaDelivery.model.Ingredient;
import com.example.pizzaDelivery.model.Pizza;
import com.example.pizzaDelivery.model.PizzaOrder;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.List;
import java.lang.reflect.Type;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@SessionAttributes("pizzaOrder")
public class DesignPizzaController {
    @ModelAttribute
    public void addIngredientsToModel(Model model){
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("CRNM","Carne molida", Ingredient.Type.PROTEIN),
                new Ingredient("JMON","Jamon", Ingredient.Type.PROTEIN),
                new Ingredient("CHRZ","Chorizo", Ingredient.Type.PROTEIN),
                new Ingredient("SALC","Salchicha", Ingredient.Type.PROTEIN),

                new Ingredient("CHAM","Champiñones", Ingredient.Type.VEGGIES),
                new Ingredient("JALP","Jalapeños", Ingredient.Type.VEGGIES),
                new Ingredient("PINA","Piña", Ingredient.Type.VEGGIES),
                new Ingredient("ANCH","Anchoas", Ingredient.Type.VEGGIES),
                new Ingredient("ALBC","Albaca", Ingredient.Type.VEGGIES),

                new Ingredient("GODA","Goda", Ingredient.Type.CHEESES),
                new Ingredient("PARM","Pamesano", Ingredient.Type.CHEESES),
                new Ingredient("MOZA","Manchego", Ingredient.Type.CHEESES),
                new Ingredient("PHIL","Philadelphia", Ingredient.Type.CHEESES),

                new Ingredient("SATO","Salsa de tomate", Ingredient.Type.SAUCES),
                new Ingredient("SPIC","Salsa picante", Ingredient.Type.SAUCES),
                new Ingredient("VALE","Valentina", Ingredient.Type.SAUCES)

                );
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

    public Iterable<Ingredient> filteredByType(List<Ingredient> ingredients, Ingredient.Type type){
        return ingredients.stream().filter(
                x->x.getType().equals(type)
        ).collect(Collectors.toList());
    }





}
