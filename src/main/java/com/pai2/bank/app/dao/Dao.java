package com.pai2.bank.app.dao;

import javassist.NotFoundException;

import javax.ejb.Remote;
import java.io.Serializable;
import java.util.Set;

@Remote
public interface Dao<K, E> extends Serializable {

    /**
     * Saves an E entity to database
     * @param entity
     * @return newly created entity
     */
    public E persist(E entity);

    /**
     * Marges objects with the same identifier within a session into a newly
     * created object.
     *
     * @param entity
     * @return a newly created instance merged.
     */
    public E merge(E entity);

    /**
     * Deletes the entity.
     *
     * @param id of entity
     * @throws NotFoundException if the user does not exist in database.
     */
    public boolean remove(K id);

    /**
     * Deletes the entity.
     *
     * @param id entity
     * @throws NotFoundException if the entity does not exist in database.
     */
    public E findById(K id);

    /**
     * Finds all objects of an entity class.
     *
     * @return List with objects
     */
    public Set<E> getAll();
}