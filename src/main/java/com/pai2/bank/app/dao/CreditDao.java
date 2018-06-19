package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Credit;

import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */
public interface CreditDao extends Dao<Integer, Credit> {
    List<Credit> findCreditById(Integer creditId);
}
