package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Investmentoffer;

import java.util.List;

public interface InvestmentofferDAO extends Dao<Integer, Investmentoffer> {
    List<Investmentoffer> findInvestmentofferByStateOfOffer(String stateOfOffer);

}
