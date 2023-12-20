package com.netpeakgroup.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summingInt;

@Service
public class DomainCalculatorServiceImpl implements DomainCalculatorService {
    @Override
    public Map<String, Integer> calculateDomains(List<String> emails) {
        return emails.stream()
                .collect(
                        Collectors.groupingBy(
                                domain -> domain.substring(
                                        domain.indexOf("@") + 1
                                ),
                                summingInt(x -> 1)
                        )
                );
    }
}
