package com.pluralsight.globomantics.springintegration.service;

public interface RegistrationService {
    void commit(String userId);
    void commitCustomized(String userId);
}
