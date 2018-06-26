package com.pai2.bank.app.controller;

import com.pai2.bank.app.model.Banktransfer;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BankTransferControllerTest {

    private BankTransferController bankTransferController = new BankTransferController();

    @Test
    void makeTransaction() {
        bankTransferController = mock(BankTransferController.class);
//        Response response = mock(Response.class);
        when(bankTransferController.makeTransaction(any())).thenReturn(Response.ok().entity("").build());
        String result =(String) bankTransferController.makeTransaction(new Banktransfer()).getEntity();
        assertNotNull(result);
    }


    @Test
    void registerTransaction() {
    }
}