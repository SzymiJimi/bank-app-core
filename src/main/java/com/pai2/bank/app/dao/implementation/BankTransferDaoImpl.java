package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.BankTransferDao;
import com.pai2.bank.app.model.Banktransfer;
import com.pai2.bank.app.model.User;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */
@Stateless(name = "BankTransferDaoImpl", mappedName = "BankTransferDaoImpl")
public class BankTransferDaoImpl extends DaoImpl<Integer, Banktransfer> implements BankTransferDao {

    @Override
    public User findUser(Integer accountId) {
        System.out.println("Weszło w szukanie usera");
        Query query =getEntityManager().createNamedQuery("Banktransfer.findUserByOwner");
        System.out.println("Stworzyło query");
        query.setParameter("bankAcc", accountId);
        System.out.println("Ustawiono parametr query");
        System.out.println( "Wynik: "+ query.getSingleResult());
        return (User) query.getSingleResult();
    }
}
