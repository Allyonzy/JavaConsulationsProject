package ru.innopolis;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
}
