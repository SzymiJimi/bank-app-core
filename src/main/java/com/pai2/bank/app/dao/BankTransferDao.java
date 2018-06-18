package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Banktransfer;
import com.pai2.bank.app.model.User;

import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */
public interface BankTransferDao extends Dao<Integer, Banktransfer> {

        User findUser(Integer accountId);

}
