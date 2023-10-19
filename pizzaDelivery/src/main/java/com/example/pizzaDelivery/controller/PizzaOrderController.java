package com.example.pizzaDelivery.controller;

import com.example.pizzaDelivery.model.PizzaOrder;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("pizzaOrder")
public class PizzaOrderController {
    @GetMapping("/current")
    public String orderForm(){
        return "order";
    }
    @PostMapping
    public String processForm(@Valid PizzaOrder order, Errors error, SessionStatus sessionSatus){
        if(error.hasErrors()){
            return "order";
        }
        sessionSatus.setComplete();
        return "orderCompleted";
    }
}
