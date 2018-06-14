package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.BankAccountOfferDao;
import com.pai2.bank.app.model.Bankaccountoffer;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */
public class BankAccountOfferDaoImpl extends DaoImpl<Integer, Bankaccountoffer> implements BankAccountOfferDao {
    @Override
    public List<Bankaccountoffer> findOfferById(Integer bankAccountOfferId) {
        Query query = getEntityManager().createQuery("SELECT b FROM Bankaccountoffer b WHERE b.idBankAccountOffer.idBankAccountOffer="+ bankAccountOfferId);
        return new ArrayList<Bankaccountoffer>(query.getResultList());
    }
}
