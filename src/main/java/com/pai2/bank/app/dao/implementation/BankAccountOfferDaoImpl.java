package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.BankAccountOfferDao;
import com.pai2.bank.app.model.Bankaccountoffer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */
@Stateless(name = "BankAccountOfferDaoImpl" , mappedName = "BankAccountOfferDaoImpl")
public class BankAccountOfferDaoImpl extends DaoImpl<Integer, Bankaccountoffer> implements BankAccountOfferDao {

    @PersistenceContext(unitName = "bank-app")
    private EntityManager entityManager;

    public void save(Bankaccountoffer bankaccountoffer){{
        entityManager.persist(bankaccountoffer);
    }
    }
}
