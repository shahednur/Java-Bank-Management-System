package com.bank.backend.dto.response;

import com.bank.backend.entity.User.UserType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreatedDTO {
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters")
    private String password;

    @NotBlank(message = "Email is required")
    @Size(max = 100, message = "Email can not exceed 100 characters")
    private String email;

    @Size(max = 15, message = "Phone can not exceed 15 characters")
    private String phone;

    @NotNull(message = "User type is required")
    private UserType userType;
}
