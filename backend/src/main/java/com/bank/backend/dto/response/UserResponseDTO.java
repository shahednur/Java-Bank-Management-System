package com.bank.backend.dto.response;

import java.time.LocalDateTime;

import com.bank.backend.entity.User;
import com.bank.backend.entity.User.UserStatus;
import com.bank.backend.entity.User.UserType;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//User Response DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDTO {
    private Long userId;
    private String username;
    private String email;
    private String phone;
    private UserType userType;
    private UserStatus status;
    private LocalDateTime lastLogin;
    private Integer failedLotinAttempts;
    private LocalDateTime accountLockedUntil;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isAccountLocked;

}