package ru.innopolis.testseveraljoinsmodel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.testseveraljoinsmodel.model.Matches;

public interface MatchesRepository extends JpaRepository<Matches, Long> {
}
