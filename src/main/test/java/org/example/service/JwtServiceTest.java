package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtServiceTest {

    private JwtService jwtService;

    @BeforeEach
    void setUp() {
        jwtService = new JwtService();
        jwtService.secret = "YourJWTSecretKeyForEncryption123456";
        jwtService.jwtExpiration = 3600000; // 1 hour
    }

    @Test
    void testGenerateToken() {
        String token = jwtService.generateToken("testUser");
        assertNotNull(token);
        assertTrue(token.startsWith("eyJ")); // Basic JWT structure check
    }

    @Test
    void testExtractUsername() {
        String token = jwtService.generateToken("testUser");
        String username = jwtService.extractUsername(token);
        assertEquals("testUser", username);
    }

    @Test
    void testValidateToken() {
        String token = jwtService.generateToken("testUser");
        assertTrue(jwtService.validateToken(token));

        String invalidToken = "invalidToken";
        assertFalse(jwtService.validateToken(invalidToken));
    }
}