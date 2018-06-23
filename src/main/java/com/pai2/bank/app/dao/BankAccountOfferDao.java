package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Bankaccountoffer;

/**
 * Created by Szymon on 14.06.2018.
 */

public interface BankAccountOfferDao extends Dao<Integer, Bankaccountoffer> {

    public void save(Bankaccountoffer bankaccountoffer);
    Bankaccountoffer findByIdOffer(Integer id);

}
