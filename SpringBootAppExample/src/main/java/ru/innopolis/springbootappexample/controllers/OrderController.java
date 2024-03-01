package ru.innopolis.springbootappexample.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.springbootappexample.model.User;
import ru.innopolis.springbootappexample.services.OrderService;
import ru.innopolis.springbootappexample.services.UsersServices;

import java.util.ArrayList;
import java.util.List;

/**
 * localhost:8080/orders
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    /**
     * HTTP протокол
     * get - получить данные по ссылке
     */
    @GetMapping
    public String getUsersPage(Model model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders";
    }

}
