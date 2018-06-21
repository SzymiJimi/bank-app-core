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
        Query query =getEntityManager().createNamedQuery("Banktransfer.findUserByOwner");
        query.setParameter("bankAcc", accountId);
        return (User) query.getSingleResult();
    }

    @Override
    public List<Banktransfer> getListByAccountId(Integer accountId) {
        Query query =getEntityManager().createNamedQuery("Banktransfer.findByAccountId");
        query.setParameter("idBankAcc", accountId);
        return (List<Banktransfer>)query.getResultList();
    }
}
