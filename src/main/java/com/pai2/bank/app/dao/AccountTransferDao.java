package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Accounttransfer;

import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */
public interface AccountTransferDao extends Dao<Integer, Accounttransfer> {

   // public Set<Accounttransfer> getAllAccountTransfer();
    List<Accounttransfer> findAccountTransferbyBankAccountId(Integer bankAccountId);


}
