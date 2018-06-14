package com.pai2.bank.app.dao;

import com.pai2.bank.app.model.Address;

import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */
public interface AddressDao extends Dao<Integer, Address> {
    List<Address> findAdresById(Integer addressId);
}
