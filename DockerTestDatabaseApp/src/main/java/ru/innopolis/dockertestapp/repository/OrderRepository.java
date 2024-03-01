package ru.innopolis.dockertestapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.dockertestapp.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
