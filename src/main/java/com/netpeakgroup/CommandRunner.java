package com.netpeakgroup;

import com.netpeakgroup.exception.EmailFormatException;
import com.netpeakgroup.service.DomainCalculatorService;
import com.netpeakgroup.service.EmailValidatorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Component
public class CommandRunner implements CommandLineRunner {

    private final DomainCalculatorService domainCalculatorService;
    private final EmailValidatorService emailValidatorService;

    public CommandRunner(DomainCalculatorService domainCalculatorService,
                         EmailValidatorService emailValidatorService) {
        this.domainCalculatorService = domainCalculatorService;
        this.emailValidatorService = emailValidatorService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<String> emails = inputFromConsole();
        Map<String, Integer> result = this.domainCalculatorService.calculateDomains(emails);
        displayInConsole(result);
    }

    private List<String> inputFromConsole() {
        List<String> emails = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter emails and type \"calculate\":");
        while(true) {
            String line = scanner.nextLine();
            if(line.equals("calculate"))
                break;
            try {
                emailValidatorService.validateFormat(line);
            } catch (EmailFormatException e) {
                System.out.println(e.getMessage());
                continue;
            }
            emails.add(line);
        }
        return emails;
    }

    private void displayInConsole(Map<String, Integer> result) {
        if(result.isEmpty())
            System.out.println("No result!!!");
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
