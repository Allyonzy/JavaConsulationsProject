package ru.innopolis.springbootappexample.services;

import ru.innopolis.springbootappexample.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
}
