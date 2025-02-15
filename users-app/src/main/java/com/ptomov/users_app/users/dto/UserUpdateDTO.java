package com.ptomov.users_app.users.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO {

    @Size(min = 2, max = 50, message = "Name must be between 2 and 100 characters")
    private String name;

    @Size(min = 2, max = 100, message = "Username must be between 2 and 100 characters")
    private String username;

    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
}