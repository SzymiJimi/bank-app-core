package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Banktransfer;

import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */
public interface BankTransferDao extends Dao<Integer, Banktransfer> {

    List<Banktransfer> findTransferById(Integer transferId);

}
