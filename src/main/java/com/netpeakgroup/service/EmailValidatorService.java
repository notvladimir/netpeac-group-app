package com.netpeakgroup.service;

import com.netpeakgroup.exception.EmailFormatException;

public interface EmailValidatorService {
    void validateFormat(String email) throws EmailFormatException;
}
