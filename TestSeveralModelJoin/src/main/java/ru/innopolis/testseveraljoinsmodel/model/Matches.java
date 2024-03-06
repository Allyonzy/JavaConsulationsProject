package ru.innopolis.testseveraljoinsmodel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="matches")
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long matchesId;

    @ManyToOne
    @JoinColumn(name="player_id", nullable = false)
    private Player currentPlayer;

//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "game_id")
//    private Game game;

}
