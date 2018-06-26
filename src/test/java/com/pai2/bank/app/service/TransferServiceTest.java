package com.pai2.bank.app.service;

import com.pai2.bank.app.controller.BankTransferController;
import com.pai2.bank.app.model.Bankaccount;
import com.pai2.bank.app.model.Banktransfer;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TransferServiceTest {

    private TransferService transferService = new TransferService();

    @Test
    void changeAvaibleFounds() {
        BigDecimal amout1 = new BigDecimal(10);
        BigDecimal amout2 = new BigDecimal(2);
        Bankaccount bankaccount =  new Bankaccount(1, amout1);
        Bankaccount newBankAccount =  transferService.changeAvaibleFounds(bankaccount, amout2);
        assertEquals(newBankAccount.getAmount(), amout1.subtract(amout2));

    }
}