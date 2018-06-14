package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.ExternalAccount;
import com.pai2.bank.app.model.Externalaccount;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */
public class ExternalAccountDaoImpl extends DaoImpl<Integer, Externalaccount> implements ExternalAccount{
    @Override
    public List<ExternalAccount> findExternalAccountById(Integer externalAccountId) {
        Query query = getEntityManager().createQuery("SELECT b FROM Externalaccount b WHERE b.idExternalAccount.idExternalAccount="+ externalAccountId );
        return new ArrayList<ExternalAccount>(query.getResultList());
    }
}
