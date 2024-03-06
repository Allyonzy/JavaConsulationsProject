package ru.innopolis.testseveraljoinsmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.testseveraljoinsmodel.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
