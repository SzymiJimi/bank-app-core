package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.Dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;
import javax.ws.rs.NotFoundException;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class DaoImpl <K, E> implements Dao<K, E> {

    protected Class<E> entityClass;

    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext(unitName = "bank-app")
    private EntityManager entityManager;

    public DaoImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
    }

    @PostConstruct
    private void createEntityManager() {
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("bank-app");
            entityManager = entityManagerFactory.createEntityManager();
        }catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e.toString());
        }

    }

    @PreDestroy
    private void closeEntityManager() {
        entityManager.close();
        entityManagerFactory.close();
    }


    /**
     * Deletes the entity.
     *
     * @param id entity
     * @throws NotFoundException if the entity does not exist in database.
     */
    @Override
    public E findById(K id) {
        E entity = getEntityManager().find(entityClass, id);
        if (entity != null) {
            return entity;
        }
        return null;
    }

    /**
     * Finds all objects of an entity class.
     *
     * @return List with objects
     */
    @Override
    public Set<E> getAll() {
        Query query = getEntityManager().createQuery("from " + entityClass.getCanonicalName() + " e", entityClass);
        List<E> res = query.getResultList();
        return new HashSet<E>(res);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }



}
