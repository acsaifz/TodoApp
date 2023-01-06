package hu.acsaifz.todoapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {
    private String name;
    private String username;
    private String email;
    private int age;
    private String password;
}

