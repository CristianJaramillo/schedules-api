/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jccg.schedules.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
@WebListener
public class EntityManagerFactoryServlet implements ServletContextListener
{    
    private static final Logger logger = LogManager.getLogger(EntityManagerFactoryServlet.class.getName());
    private static final String JPA = "com.jccg.schedules.api.jpa";
    private static final Boolean DEBUG = true;
    private static EntityManagerFactory entityManagerFactory;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) 
    {
        if(entityManagerFactory == null)
            entityManagerFactory = Persistence.createEntityManagerFactory(JPA);
        if(DEBUG)
            logger.info("EntityManagerFactory create");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) 
    {
        if(entityManagerFactory.isOpen() || entityManagerFactory != null)
            entityManagerFactory.close();
        if(DEBUG)
            logger.info("EntityManagerFactory close");        
    }
    
    public static EntityManager createEntityManager() {
        if (entityManagerFactory == null)
            throw new IllegalStateException("Context is not initialized yet.");
        return entityManagerFactory.createEntityManager();
    }
    
}
