package ru.innopolis.site.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.site.models.Account;

import java.util.Optional;

/**
 * 
 * MVC
 *
 * 
 * @version v1.0
 */
public interface AccountsRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
//    boolean existsByConfirmId(String confirmId);
    Optional<Account> findByConfirmId(String confirmId);
}
