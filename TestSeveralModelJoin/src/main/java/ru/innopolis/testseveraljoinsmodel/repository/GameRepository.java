package ru.innopolis.testseveraljoinsmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.testseveraljoinsmodel.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}
