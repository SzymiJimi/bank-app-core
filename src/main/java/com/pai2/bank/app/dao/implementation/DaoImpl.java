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
     * Saves an E entity to database
     *
     * @param entity
     * @return newly created entity
     */
    @Override
    public E persist(E entity) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().flush();
            getEntityManager().clear();
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }
        return entity;
    }

    /**
     * Marges objects with the same identifier within a session into a newly
     * created object.
     *
     * @param entity
     * @return a newly created instance merged.
     */
    @Override
    public E merge(E entity)
    {
        try {
            getEntityManager().getTransaction().begin();
            entity = getEntityManager().merge(entity);
            getEntityManager().flush();
            getEntityManager().clear();
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param id of entity
     * @throws NotFoundException if the user does not exist in database.
     */
    @Override
    public boolean remove(K id) {
        E entity = this.findById(id);
        if (entity != null) {
            try {
                getEntityManager().getTransaction().begin();
                getEntityManager().remove(entity);
                getEntityManager().flush();
                getEntityManager().clear();
                getEntityManager().getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                getEntityManager().getTransaction().rollback();
            }
            return true;
        } else {
            return false;
        }
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
