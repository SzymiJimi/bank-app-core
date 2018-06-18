package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Bankaccount;

import java.util.List;


public interface BankAccountDao extends Dao<Integer,Bankaccount> {

    List<Bankaccount> findBankAccountsByClientId(Integer userId);

}
