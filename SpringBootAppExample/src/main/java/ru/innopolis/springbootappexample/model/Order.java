package ru.innopolis.springbootappexample.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(includeFieldNames = false)
@Builder
@Entity
@Table(name="order_test")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

//    @DateTimeFormat(pattern="dd.MM.yyyy HH:mm:ss.SSS")
//    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern="dd.MM.yyyy")
    @Column(name="order_date")
    private LocalDate orderDate;
}
