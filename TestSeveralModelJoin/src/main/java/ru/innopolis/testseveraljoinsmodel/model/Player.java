package ru.innopolis.testseveraljoinsmodel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long playerId;
    private String name;

    @OneToMany(mappedBy="currentPlayer")
    private List<Matches> matchesList;

    @OneToMany(mappedBy="scoreByPlayer")
    private List<Score> scoreList;

}
