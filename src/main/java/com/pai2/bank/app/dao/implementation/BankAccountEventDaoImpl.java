package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.BankAccounteventDao;
import com.pai2.bank.app.model.Bankaccountevent;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */
public class BankAccountEventDaoImpl extends DaoImpl<Integer, Bankaccountevent> implements BankAccounteventDao {
    @Override
    public List<Bankaccountevent> findBankAccountEventById(Integer bankAccountEventId) {
        Query query = getEntityManager().createQuery("SELECT b FROM Bankaccountevent b WHERE b.idBankAccountEvent.idBankAccountEvent ="+ bankAccountEventId);
        System.out.println("Wyniki pobierania tranzakcji: "+query.getResultList());
        return new ArrayList<Bankaccountevent>(query.getResultList());
    }
}
