package ru.innopolis.dockertestapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.dockertestapp.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
