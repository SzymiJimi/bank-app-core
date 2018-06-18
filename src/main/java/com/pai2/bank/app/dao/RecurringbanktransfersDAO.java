package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Recurringbanktransfers;

public interface RecurringbanktransfersDAO extends Dao<Integer, Recurringbanktransfers> {
    public Recurringbanktransfers findRecurringbanktransferById(Integer idRecurringbanktransfer);
}
