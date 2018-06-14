package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.AddressDao;
import com.pai2.bank.app.dao.Dao;
import com.pai2.bank.app.model.Address;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */
@Stateless(name = "AddressDaoImpl", mappedName = "AddressDaoImpl")
public class AddressDaoImpl extends DaoImpl<Integer, Address> implements AddressDao {


    @Override
    public List<Address> findAdresById(Integer addressId) {
        Query query = (Query) getEntityManager().createQuery("SELECT b FROM Address b WHERE b.idAdress.idAdress="+ addressId);
        System.out.println("Wyniki pobierania tranzakcji: "+query.getResultList());

        return new ArrayList<Address>(query.getResultList());
    }
}
