package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.CreditOfferDao;
import com.pai2.bank.app.model.Creditoffer;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */
public class CreditOfferDaoImpl extends DaoImpl<Integer, Creditoffer> implements CreditOfferDao {
    @Override
    public List<Creditoffer> findCreditOfferById(Integer creditOfferId) {
        Query query = getEntityManager().createQuery("SELECT b FROM Creditoffer b WHERE b.idCreditOffer.idCreditOffer="+ creditOfferId );
        return new ArrayList<Creditoffer>(query.getResultList());
    }
}
