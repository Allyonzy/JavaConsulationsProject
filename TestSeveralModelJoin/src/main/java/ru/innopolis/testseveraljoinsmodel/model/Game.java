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
@Table(name="game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="game_id")
    private Long gameId;
    private String name;
    @Column(name="score_type")
    private String scoreType;

//    @OneToOne(mappedBy="game", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private Matches matches;

}
