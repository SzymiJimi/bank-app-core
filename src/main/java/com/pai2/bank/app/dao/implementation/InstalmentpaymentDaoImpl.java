package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.InstalmentpaymentDAO;
import com.pai2.bank.app.model.Instalmentpayment;

import javax.ejb.Stateless;

@Stateless(name = "InstalmentpaymentDaoImpl", mappedName = "InstalmentpaymentDaoImpl")
public class InstalmentpaymentDaoImpl extends DaoImpl<Integer, Instalmentpayment> implements InstalmentpaymentDAO {
}
