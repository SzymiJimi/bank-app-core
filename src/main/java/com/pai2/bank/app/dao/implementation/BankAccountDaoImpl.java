package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.BankAccountDao;
import com.pai2.bank.app.model.Bankaccount;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "BankAccountDaoImpl", mappedName = "BankAccountDaoImpl")
public class BankAccountDaoImpl  extends DaoImpl<Integer, Bankaccount> implements BankAccountDao {


    @Override
    public List<Bankaccount> findBankAccountsByClientId(Integer clientId) {
        Query query = getEntityManager().createQuery("SELECT b FROM Bankaccount b WHERE b.idClient.idUser.idUser="+ clientId);
        System.out.println("Wyniki pobierania kont: "+query.getResultList());
        return new ArrayList<Bankaccount>(query.getResultList());
    }

    @Override
    public Bankaccount findByAccountNumber(String accountNumber) {
        try{
            Query query =getEntityManager().createNamedQuery("Bankaccount.findByAccountNumber");
            query.setParameter("accountNumber", accountNumber);
            Bankaccount bankaccount = (Bankaccount) query.getSingleResult();
            return bankaccount;
        }catch(NoResultException e){
            System.out.println(e.toString());
         return null;
        }
    }
}
