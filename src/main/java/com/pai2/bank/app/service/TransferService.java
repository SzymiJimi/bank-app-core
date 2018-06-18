package com.pai2.bank.app.service;

import com.pai2.bank.app.dao.BankTransferDao;
import com.pai2.bank.app.model.Accounttransfer;
import com.pai2.bank.app.model.Banktransfer;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless(name = "TransferService", mappedName = "TransferService")
public class TransferService {

    @EJB(beanInterface = BankTransferDao.class, beanName = "BankTransferDaoImpl")
    private BankTransferDao bankTransferDao;

    @Inject
    private TransferReceipientService transferReceipientService;

    public void registerTransaction(Banktransfer banktransfer){
        Accounttransfer accounttransfer= transferReceipientService.setTransactionReceipient(banktransfer.getToAccount());
        banktransfer.setToAccount(accounttransfer);
        Banktransfer returnedTransfer= bankTransferDao.persist(banktransfer);
        System.out.println(returnedTransfer);

    }

}
