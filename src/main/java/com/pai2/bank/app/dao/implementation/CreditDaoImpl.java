package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.CreditDao;
import com.pai2.bank.app.model.Credit;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */
public class CreditDaoImpl extends DaoImpl<Integer, Credit> implements CreditDao {
    @Override
    public List<Credit> findCreditById(Integer creditId) {
        Query query = getEntityManager().createQuery("SELECT b FROM Credit b WHERE b.idCredit.idCredit="+ creditId);
        return new ArrayList<Credit>(query.getResultList());
    }
}
