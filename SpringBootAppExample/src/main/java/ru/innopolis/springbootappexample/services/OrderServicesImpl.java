package ru.innopolis.springbootappexample.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.innopolis.springbootappexample.model.Order;
import ru.innopolis.springbootappexample.model.User;
import ru.innopolis.springbootappexample.repositories.OrderRepository;
import ru.innopolis.springbootappexample.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServicesImpl implements OrderService {

    private final OrderRepository orderRepository;

    /**
     * Получить всех пользователей из БД
     * @return список пользователей
     */
    @Override
    public List<Order> getAll() {
        return orderRepository.findAll(); //Select * from user;
    }
}
