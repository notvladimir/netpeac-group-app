package com.netpeakgroup.test.service;

import com.netpeakgroup.exception.EmailFormatException;
import com.netpeakgroup.service.EmailValidatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test EmailValidatorService")
@SpringBootTest(classes = TestApplicationConfiguration.class)
class EmailValidatorServiceTest {

    @Autowired
    private EmailValidatorService emailValidatorService;

    @Test
    @DisplayName("Validate email format when format valid")
    void whenEmailFormatValid_thenSuccess() {
        String email = "test@gmail.com";
        try {
            emailValidatorService.validateFormat(email);
        } catch (EmailFormatException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Validate email format when format not valid")
    void whenEmailFormatNotValid_thenThrowException() {
        String email = "testgmail.com";
        Exception exception = assertThrows(EmailFormatException.class, () -> {
            emailValidatorService.validateFormat(email);
        });
        assertEquals("Email format not valid: testgmail.com", exception.getMessage());
    }
}
