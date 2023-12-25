package ru.ahmetdavresh.springwebmini.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty(message = "Адрес электронной почты не должен быть пустым!")
    @Email
    private String email;
    @NotEmpty(message = "Пароль не должен быть пустым!")
    private String password;
}