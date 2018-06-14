package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Externalaccount;

import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */
public interface ExternalAccount extends Dao<Integer, Externalaccount> {
    List<ExternalAccount> findExternalAccountById(Integer externalAccountId);
}
