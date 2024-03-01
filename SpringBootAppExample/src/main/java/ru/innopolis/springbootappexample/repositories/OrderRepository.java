package ru.innopolis.springbootappexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.innopolis.springbootappexample.model.Order;
import ru.innopolis.springbootappexample.model.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
