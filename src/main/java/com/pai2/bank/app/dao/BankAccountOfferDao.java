package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Bankaccountoffer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */

public interface BankAccountOfferDao extends Dao<Integer, Bankaccountoffer> {

    public void save(Bankaccountoffer bankaccountoffer);


}
