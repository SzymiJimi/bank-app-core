package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.InvestmentDAO;
import com.pai2.bank.app.model.Investment;
import javax.ejb.Stateless;

@Stateless(name = "InvestmentDaoImpl", mappedName = "InvestmentDaoImpl")
public class InvestmentDaoImpl extends DaoImpl<Integer, Investment> implements InvestmentDAO {
}
