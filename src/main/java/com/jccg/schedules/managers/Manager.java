/**
 * 
 */
package com.jccg.schedules.managers;

import javax.persistence.EntityTransaction;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class Manager
{  
    private EntityTransaction entityTransaction;

    public EntityTransaction getEntityTransaction() {
        return entityTransaction;
    }

    public void setEntityTransaction(EntityTransaction entityTransaction) {
        this.entityTransaction = entityTransaction;
    }    
    
    public void active()
    {
        if(!entityTransaction.isActive())
            entityTransaction.begin();
    }
    
    public void commit()
    {
        entityTransaction.commit();
    }
    
}
