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
@Table(name="score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="score_id")
    private Long scoreId;

    @Column(name="score_type")
    private String scoreType;

    @ManyToOne
    @JoinColumn(name="player_id", nullable = false)
    private Player scoreByPlayer;
}
