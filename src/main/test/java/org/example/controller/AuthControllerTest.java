package org.example.controller;

import org.example.dto.AuthRequest;
import org.example.dto.AuthResponse;
import org.example.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthControllerTest {

    private UserService userService;
    private AuthController authController;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        authController = new AuthController(userService);
    }

    @Test
    void register() {
        AuthRequest request = new AuthRequest("testUser", "password");
        AuthResponse response = new AuthResponse("mockJwtToken");
        when(userService.register(request)).thenReturn(response);

        ResponseEntity<AuthResponse> result = authController.register(request);

        assertEquals(200, result.getStatusCodeValue());
        assertEquals("mockJwtToken", result.getBody().getToken());
    }

    @Test
    void login() {
        AuthRequest request = new AuthRequest("testUser", "password");
        AuthResponse response = new AuthResponse("mockJwtToken");
        when(userService.login(request)).thenReturn(response);

        ResponseEntity<AuthResponse> result = authController.login(request);

        assertEquals(200, result.getStatusCodeValue());
        assertEquals("mockJwtToken", result.getBody().getToken());
    }
}