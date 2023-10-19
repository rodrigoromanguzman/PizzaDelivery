package com.example.pizzaDelivery.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class PizzaOrder {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Date placeAt;
    @NotNull
    @NotBlank(message = "Insertar Nombre")
    private String deliveryName;
    @NotNull
    @NotBlank(message = "Insertar Nombre")
    private String deliveryStreet;
    @NotNull
    @NotBlank(message = "Insertar Nombre")
    private String deliveryCity;
    @NotNull
    @NotBlank(message = "Insertar Nombre")
    private String deliveryState;
    @NotNull
    @NotBlank(message = "Insertar Nombre")
    @Pattern(regexp = "/^[0-9]{5}(?:-[0-9]{4})?$/;")
    private String deliveryZip;
    @NotNull
    @NotBlank(message = "Insertar Nombre")
    @Pattern(regexp = "\n" +
            "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|6(?:011|5[0-9]{2})[0-9]{12}(?:2131|1800|35\\d{3})\\d{11})$" )
    private String ccNumber;
    @NotNull
    @NotBlank(message = "Insertar Nombre")
    private String ccExpiration;
    @NotNull
    @NotBlank(message = "Insertar Nombre")
    @Digits(integer=3,fraction=0,message = "Ingresar 3 digitos")
    private String ccCVV;

    private List<Pizza> pizzas= new ArrayList<>();

    public void addPizza(Pizza newPizza){
        this.pizzas.add(newPizza);
    }
}
