package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Bankaccountoffer;

import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */

public interface BankAccountOfferDao extends Dao<Integer, Bankaccountoffer> {

    public void save(Bankaccountoffer bankaccountoffer);
    List<Bankaccountoffer> findByIdOffer(Integer id);

    List<Bankaccountoffer> findOfferByManagerId(Integer managerId);
}
