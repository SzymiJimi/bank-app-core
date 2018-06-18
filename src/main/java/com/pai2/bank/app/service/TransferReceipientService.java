package com.pai2.bank.app.service;

import com.pai2.bank.app.dao.AccountTransferDao;
import com.pai2.bank.app.dao.BankAccountDao;
import com.pai2.bank.app.dao.ExternalAccountDao;
import com.pai2.bank.app.model.Accounttransfer;
import com.pai2.bank.app.model.Bankaccount;
import com.pai2.bank.app.model.Externalaccount;
import org.jboss.logging.annotations.Param;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "TransferReceipientService", mappedName = "TransferReceipientService")
public class TransferReceipientService {


    @EJB(beanInterface = AccountTransferDao.class, beanName = "AccountTransferDaoImpl")
    private AccountTransferDao accountTransferDao;

    @EJB(beanInterface = BankAccountDao.class, beanName = "BankAccountDaoImpl")
    private BankAccountDao bankAccountDao;

    @EJB(beanInterface = ExternalAccountDao.class, beanName = "ExternalAccountDaoImpl")
    private ExternalAccountDao externalAccountDao;

    public Accounttransfer setTransactionReceipient(Accounttransfer accounttransfer) {

//        try{
        System.out.println("Numerek konta: "+accounttransfer.getIdInternalAccount());
        Accounttransfer result = accountTransferDao.findById(accounttransfer.getRecipientAccount());

        if (result != null) {

            return accountTransferDao.persist(result);
        } else {
            try {
                Bankaccount bankaccount = bankAccountDao.findByAccountNumber(accounttransfer.getRecipientAccount());
                bankAccountDao.persist(bankaccount);
                accounttransfer.setIdExternalAccount(null);
                accounttransfer.setIdInternalAccount(bankaccount);
                return accountTransferDao.persist(accounttransfer);
            } catch (Exception e) {
                System.out.println("Nie znalazło konta... "+ e.toString());
                System.out.println(e.toString());
                Externalaccount externalaccount = new Externalaccount();
                externalaccount.setAccountNumber(accounttransfer.getRecipientAccount());
                Externalaccount returnedAccount = externalAccountDao.persist(externalaccount);
                accounttransfer.setIdExternalAccount(returnedAccount);
                return accountTransferDao.persist(accounttransfer);
            }
        }

    }

}
