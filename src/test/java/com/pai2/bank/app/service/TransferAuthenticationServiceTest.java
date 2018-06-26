package com.pai2.bank.app.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransferAuthenticationServiceTest {

    private TransferAuthenticationService authenticationService = new TransferAuthenticationService();


    @Test
    void generateCode() {
        String code= authenticationService.generateCode();
        Integer length = code.length();
        assertNotNull(code);
        assertEquals(8, (int) length);
    }
}