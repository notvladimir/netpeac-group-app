package com.netpeakgroup.service;

import java.util.List;
import java.util.Map;

public interface DomainCalculatorService {
    Map<String, Integer> calculateDomains(List<String> emails);
}
