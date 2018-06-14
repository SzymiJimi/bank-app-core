package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.IncomeDAO;
import com.pai2.bank.app.model.Income;

import javax.ejb.Stateless;

@Stateless(name = "IncomeDaoImpl", mappedName = "IncomeDaoImpl")
public class IncomeDaoImpl extends DaoImpl<Integer, Income> implements IncomeDAO {
}
