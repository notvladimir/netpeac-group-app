package com.netpeakgroup.service;

import com.netpeakgroup.exception.EmailFormatException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class EmailValidatorServiceImpl implements EmailValidatorService {

    private static final String EMAIL_REGEX_PATTERN = "^(.+)@(\\S+)$";

    @Override
    public void validateFormat(String email) throws EmailFormatException {
        boolean valid = Pattern.compile(EMAIL_REGEX_PATTERN)
                .matcher(email)
                .matches();
        if(!valid)
            throw new EmailFormatException("Email format not valid: " + email);
    }
}
