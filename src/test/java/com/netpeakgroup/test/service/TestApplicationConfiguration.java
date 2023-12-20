package com.netpeakgroup.test.service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.netpeakgroup.service")
@EnableAutoConfiguration
public class TestApplicationConfiguration {
}
