package com.bkenterprises.invoices.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SecurityServiceImpl implements SecurityService {

    public String generateUUID(IdentifierType identifierType) {
        return UUID.randomUUID().toString();
    }

}
