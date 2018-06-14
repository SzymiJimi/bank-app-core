package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.BankTransferDao;
import com.pai2.bank.app.model.Banktransfer;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */
public class BankTransferDaoImpl extends DaoImpl<Integer, Banktransfer> implements BankTransferDao {
    @Override
    public List<Banktransfer> findTransferById(Integer transferId) {
        Query query = getEntityManager().createQuery("SELECT b FROM Banktransfer b WHERE b.idBankTransfer.idBankTransfer="+ transferId);
        return new ArrayList<Banktransfer>(query.getResultList());
    }
}
