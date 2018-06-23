package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.BankAccountOfferDao;
import com.pai2.bank.app.model.Bankaccount;
import com.pai2.bank.app.model.Bankaccountoffer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    @Override
    public Bankaccountoffer findByIdOffer(Integer idBankAccountOffer) {
    Query query = getEntityManager().createNamedQuery("Bankaccountoffer.findByIdBankAccountOffer");
    query.setParameter("idBankAccountOffer", idBankAccountOffer);
    Bankaccountoffer bankaccountoffer = (Bankaccountoffer) query.getSingleResult();
    return bankaccountoffer;
    }

}
