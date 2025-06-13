package org.example.test;

import org.example.dto.AuthRequest;
import org.example.dto.AuthResponse;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.JwtService;
import org.example.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserRepository userRepository;
    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        jwtService = mock(JwtService.class);
        passwordEncoder = mock(PasswordEncoder.class);
        userService = new UserService(userRepository, jwtService, passwordEncoder);
    }

    @Test
    void testRegister() {
        AuthRequest request = new AuthRequest("testUser", "password");
        User user = User.builder()
                .username("testUser")
                .password("encodedPassword")
                .role("USER")
                .build();

        when(passwordEncoder.encode(request.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(jwtService.generateToken(user.getUsername())).thenReturn("mockJwtToken");

        AuthResponse response = userService.register(request);

        assertEquals("mockJwtToken", response.getToken());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testLogin() {
        AuthRequest request = new AuthRequest("testUser", "password");
        User user = User.builder()
                .username("testUser")
                .password("encodedPassword")
                .role("USER")
                .build();

        when(userRepository.findByUsername(request.getUsername())).thenReturn(java.util.Optional.of(user));
        when(passwordEncoder.matches(request.getPassword(), user.getPassword())).thenReturn(true);
        when(jwtService.generateToken(user.getUsername())).thenReturn("mockJwtToken");

        AuthResponse response = userService.login(request);

        assertEquals("mockJwtToken", response.getToken());
        verify(userRepository, times(1)).findByUsername(request.getUsername());
    }

    @Test
    void testLoginInvalidCredentials() {
        AuthRequest request = new AuthRequest("testUser", "wrongPassword");
        User user = User.builder()
                .username("testUser")
                .password("encodedPassword")
                .role("USER")
                .build();

        when(userRepository.findByUsername(request.getUsername())).thenReturn(java.util.Optional.of(user));
        when(passwordEncoder.matches(request.getPassword(), user.getPassword())).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> userService.login(request));
        assertEquals("Invalid credentials", exception.getMessage());
    }
}