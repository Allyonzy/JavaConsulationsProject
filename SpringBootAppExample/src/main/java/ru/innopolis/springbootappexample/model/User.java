package ru.innopolis.springbootappexample.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="user_test")
public class User {
    public enum State {
        NOT_CONFIRMED, CONFIRMED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    private Integer age;

    private String email;
    private String password;

    @Column(name="confirm_code")
    private String confirmCode;

    @Enumerated(value = EnumType.STRING)
    @Transient
    private State state;

    @OneToMany(mappedBy="user")
    private List<Order> orders;
}
