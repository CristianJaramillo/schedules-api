/**
 * 
 */
package com.jccg.schedules.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class EntityManagerProvider
{
    private static final Logger logger = LogManager.getLogger(EntityManagerProvider.class.getName());
    private static final String JPA = "com.jccg.schedules.api.jpa";
    private static final Boolean DEBUG = true;
    private static final EntityManagerProvider entityManagerProvider = new EntityManagerProvider(); 

    private EntityManagerFactory entityManagerFactory;
    
    private EntityManagerProvider() { }

    public static EntityManagerProvider getInstance()
    {
        return entityManagerProvider;
    }
    
    public EntityManagerFactory getEntityManagerFactory()
    {
        if(entityManagerFactory == null)
            entityManagerFactory = Persistence.createEntityManagerFactory(JPA);
        
        if(DEBUG)
            logger.info("EntityManagerFactory create");
        
        return entityManagerFactory;
    }
    
    public void entityManagerFactoryClose()
    {
        if(entityManagerFactory.isOpen() || entityManagerFactory != null)
            entityManagerFactory.close();
        if(DEBUG)
            logger.info("EntityManagerFactory close");
    }
    
}
