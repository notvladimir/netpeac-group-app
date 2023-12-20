package com.netpeakgroup.test.service;

import com.netpeakgroup.service.DomainCalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test DomainCalculatorService")
@SpringBootTest(classes = TestApplicationConfiguration.class)
class DomainCalculatorServiceTest {

    @Autowired
    private DomainCalculatorService domainCalculatorService;

    @Test
    @DisplayName("Calculate domain counts")
    void whenDataCorrect_thenCalculateDomains() {
        List<String> domains = List.of(
                "test@gmail.com",
                "test1@gmail.com",
                "test2@gmail.com",
                "test@yandex.ru",
                "test1@yandex.ru",
                "test@test.ua"
        );

        Map<String, Integer> result = domainCalculatorService.calculateDomains(domains);

        assertEquals(3, result.get("gmail.com"));
        assertEquals(2, result.get("yandex.ru"));
        assertEquals(1, result.get("test.ua"));
        assertEquals(3, result.size());
    }
}
