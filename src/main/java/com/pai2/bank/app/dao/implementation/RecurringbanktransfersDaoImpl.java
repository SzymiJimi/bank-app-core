package com.pai2.bank.app.dao.implementation;
import com.pai2.bank.app.dao.RecurringbanktransfersDAO;
import com.pai2.bank.app.model.Recurringbanktransfers;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless(name = "RecurringbanktransfersDaoImpl", mappedName = "RecurringbanktransfersDaoImpl")
public class RecurringbanktransfersDaoImpl extends DaoImpl<Integer,Recurringbanktransfers> implements RecurringbanktransfersDAO {
    @Override
    public Recurringbanktransfers findRecurringbanktransferById(Integer idRecurringbanktransfer) {
        try {
            Query query = getEntityManager().createNamedQuery("Recurringbanktransfers.findByIdRecurringBankTransfers", Recurringbanktransfers.class);
            query.setParameter("idRecurringBankTransfers", idRecurringbanktransfer);
            return (Recurringbanktransfers) query.getSingleResult();
        }catch(Exception ex)
        {
            return null;
        }
    }
}

