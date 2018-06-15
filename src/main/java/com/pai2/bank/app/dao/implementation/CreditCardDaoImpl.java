package com.pai2.bank.app.dao.implementation;


import com.pai2.bank.app.dao.CreditCardDao;
import com.pai2.bank.app.model.Creditcard;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "CreditCardDaoImpl", mappedName = "CreditCardDaoImpl")
public class CreditCardDaoImpl  extends DaoImpl<Integer, Creditcard> implements CreditCardDao {



    @Override
    public List<Creditcard> findCreditCardByAccountId(Integer accountId) {
        Query query = getEntityManager().createQuery("SELECT c FROM Creditcard c WHERE c.idBankAccount.idBankAccount="+ accountId);
        return new ArrayList<Creditcard>(query.getResultList());
    }
}
