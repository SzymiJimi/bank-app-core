package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.InvestpaymentDAO;
import com.pai2.bank.app.model.Investpayment;

import javax.ejb.Stateless;

@Stateless(name = "InvestpaymentDaoImpl", mappedName = "InvestpaymentDaoImpl")
public class InvestpaymentDaoImpl extends DaoImpl<Integer, Investpayment>  implements InvestpaymentDAO {

}
