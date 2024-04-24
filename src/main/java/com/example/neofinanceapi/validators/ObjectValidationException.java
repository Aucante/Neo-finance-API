package com.example.neofinanceapi.validators;

import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class ObjectValidationException extends RuntimeException {

    private final Set<String> violations;

    private final String violationSource;
}
