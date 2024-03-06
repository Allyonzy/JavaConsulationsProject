package ru.innopolis.site.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.innopolis.site.validation.NotSameNames;
import ru.innopolis.site.validation.ValidPassword;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@NotSameNames(firstNameField = "firstName", lastNameField = "lastName", message = "{error.names.bad}")
public class SignUpForm {
    @Size(min = 4, max = 20, message = "{error.firstName.size}")
    private String firstName;

    @Size(min = 4, max = 20, message = "{error.lastName.size}")
    private String lastName;

    @Email(message = "{error.email.format}")
    private String email;

    @ValidPassword(message = "{error.password.format}")
    @NotEmpty(message = "{error.password.empty}")
    private String password;
}
