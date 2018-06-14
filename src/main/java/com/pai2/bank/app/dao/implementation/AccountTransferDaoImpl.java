package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.AccountTransferDao;
import com.pai2.bank.app.model.Accounttransfer;



import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */


@Stateless(name = "AccountTransferDaoImpl", mappedName = "AccountTransferDaoImpl")
public class AccountTransferDaoImpl extends DaoImpl<Integer, Accounttransfer> implements AccountTransferDao {


    @Override
   public List<Accounttransfer> findAccountTransferbyBankAccountId(Integer bankAccountId){
        Query query = (Query) getEntityManager().createQuery("SELECT b FROM Accounttransfer b WHERE b.idBankAccount.idBankAccount="+ bankAccountId);
        System.out.println("Wyniki pobierania tranzakcji: "+query.getResultList());
        return new ArrayList<Accounttransfer>(query.getResultList());
    }



}
