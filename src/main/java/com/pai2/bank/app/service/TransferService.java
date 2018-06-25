package com.pai2.bank.app.service;

import com.pai2.bank.app.dao.BankAccountDao;
import com.pai2.bank.app.dao.BankTransferDao;
import com.pai2.bank.app.model.Accounttransfer;
import com.pai2.bank.app.model.Bankaccount;
import com.pai2.bank.app.model.Banktransfer;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.math.BigDecimal;

@Stateless(name = "TransferService", mappedName = "TransferService")
public class TransferService {

    @EJB(beanInterface = BankTransferDao.class, beanName = "BankTransferDaoImpl")
    private BankTransferDao bankTransferDao;

    @EJB(beanInterface = BankAccountDao.class, beanName = "BankAccountDaoImpl")
    private BankAccountDao bankAccountDao;

    @Inject
    private TransferReceipientService transferReceipientService;


    private Bankaccount changeAvaibleFounds(Bankaccount bankaccount, BigDecimal transferAmount){
       BigDecimal amount =  bankaccount.getAmount();
       amount = amount.subtract(transferAmount);
               bankaccount.setAmount(amount);
        return bankaccount;

    }

    public void registerTransaction(Banktransfer banktransfer){


        Accounttransfer accounttransfer= transferReceipientService.setTransactionReceipient(banktransfer.getToAccount());
        banktransfer.setToAccount(accounttransfer);
        System.out.println("Data transferu przed dodaniem: "+banktransfer.getDateOfExecution());
        banktransfer.setDateOfExecution("");
        Bankaccount updatedAccount = changeAvaibleFounds(banktransfer.getFromAccount(), banktransfer.getAmount());
        bankAccountDao.merge(updatedAccount);
        banktransfer.setFromAccount(updatedAccount);
        Banktransfer returnedTransfer= bankTransferDao.persist(banktransfer);
        System.out.println("Dodany transfer" + returnedTransfer);

    }

}
