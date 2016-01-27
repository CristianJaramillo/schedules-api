/**
 * 
 */
package com.jccg.schedules.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 * @param <T>
 * @param <ID>
 */
public class GenericDAO <T, ID extends Serializable> implements IDAO<T, ID> 
{
    
    private Class<T> persistentClass;
    private EntityManager entityManager;

    public GenericDAO(Class<T> persistentClass)
    {
        this.persistentClass = persistentClass;
    }
    
    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void setPersistentClass(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        if(this.entityManager == null)
            this.entityManager = entityManager;
    }
    
    @Override
    public T save(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        T mergedEntity = getEntityManager().merge(entity);
        return mergedEntity;
    }

    @Override
    public void delete(T entity) {
        getEntityManager().remove(update(entity));
    }

    @Override
    public T findById(ID id) {
        T entity = getEntityManager().find(persistentClass, id);
        return entity;
    }

    @Override
    public List<T> findAll() {
        return getEntityManager()
                .createQuery("from " + getPersistentClass().getSimpleName())
                .getResultList();
    }

    @Override
    public void flush() {
        getEntityManager().flush();
    }
    
}
