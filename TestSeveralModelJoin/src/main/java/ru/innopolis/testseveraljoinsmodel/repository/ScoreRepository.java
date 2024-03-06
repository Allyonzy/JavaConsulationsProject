package ru.innopolis.testseveraljoinsmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.testseveraljoinsmodel.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
