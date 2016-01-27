/**
 * 
 */
package com.jccg.schedules.repositories;

import com.jccg.schedules.models.Model;
import java.util.HashMap;
import java.util.Map;
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
    private static final Logger logger = LogManager.getLogger(Repository.class);
    private static final Map<Long, Model> usersRepository = new HashMap<>();
    private static final Map<Long, Model> categoriesRepository = new HashMap<>();

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
    
    /**
     *
     * @return
     */
    public static Map<Long, Model> getUsersRepository()
    {        
        return usersRepository;
    }
    
    /**
     *
     * @return 
     */
    public static Map<Long, Model> getCategoriesRepository()
    {
        return categoriesRepository;
    }
    
}
