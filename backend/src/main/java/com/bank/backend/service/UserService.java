package com.bank.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bank.backend.dto.response.UserCreatedDTO;
import com.bank.backend.dto.response.UserResponseDTO;
import com.bank.backend.entity.User;
import com.bank.backend.entity.User.UserStatus;
import com.bank.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    // private final EmailService emailService;

    private static final int MAX_FAILED_ATTEMPTS = 5;
    private static final int ACCOUNT_LOCK_DURATION_HOURS = 24;
    private static final int PASSWORD_RESET_EXPIRY_HOURS = 1;

    // Create new user
    public UserCreatedDTO createUser(UserCreatedDTO createDTO){
        log.info("Creating new user with username: {}", createDTO.getUsername());

        //Check if username already exists
        

        //Check if email already exists

        User user = new User();
        user.setUsername(createDTO.getUsername());
        user.setPasswordHash(passwordEncoder.encode(createDTO.getPassword()));
        user.setEmail(createDTO.getEmail());
        user.setPhone(createDTO.getPhone());
        user.setUserType(createDTO.getUserType());
        user.setStatus(UserStatus.PENDING);

        User savedUser = userRepository.save(user);
        log.info("User created successfully with ID: ", savedUser.getUserId());

        return 
    }

    private UserResponseDTO convertToResponseDTO(User user){
        return UserResponseDTO.builder()
                .userID(user.getUserId())
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .userType(UserResponseDTO.UserType.valueOf(user.getUserType().name()))
                .status(UserResponseDTO.UserStatus.)
    }
}
