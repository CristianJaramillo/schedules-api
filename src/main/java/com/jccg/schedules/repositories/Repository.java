/**
 * 
 */
package com.jccg.schedules.repositories;

import javax.persistence.EntityTransaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class Repository
{
    
    private EntityTransaction entityTransaction;
    private static final Logger LOGGER = LogManager.getLogger(Repository.class);

    /**
     *
     */
    public void Repository()
    {       
        
    }

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
