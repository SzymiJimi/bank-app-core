package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Creditcard;

import java.util.List;


public interface CreditCardDao extends Dao<Integer,Creditcard> {

    List<Creditcard> findCreditCardByAccountId(Integer accountId);

//    void updatePin(Integer cardId);
}
