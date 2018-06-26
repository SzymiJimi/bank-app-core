package com.pai2.bank.app.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SendEmailServiceTest {

    private SendEmailService sendEmailService = new SendEmailService();

    @Test
    void sendEmail() {
       boolean result =  sendEmailService.sendEmail("rekas1@tlen.pl", "Test message", "Test email");
        assertTrue(result);
    }

}