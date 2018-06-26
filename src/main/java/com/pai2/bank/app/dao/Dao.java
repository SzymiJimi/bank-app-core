package com.pai2.bank.app.dao;

import javassist.NotFoundException;

import javax.ejb.Remote;
import java.io.Serializable;
import java.util.Set;

@Remote
public interface Dao<K, E> extends Serializable {


    public E findById(K id);

    public Set<E> getAll();

    public E persist(E entity);

    public E merge(E entity);

    public boolean remove(K id);

}