/**
 * 
 */
package com.jccg.schedules.managers;

import com.jccg.schedules.dao.EntityManagerFactoryServlet;
import com.jccg.schedules.dao.user.UserDAO;
import com.jccg.schedules.models.User;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class UserManager extends Manager
{

    private static final Logger logger = LogManager.getLogger(UserManager.class);
    private final UserDAO userDAO;
    
    /**
     *
     */
    public UserManager()
    {
        userDAO = new UserDAO();
        userDAO.setEntityManager(EntityManagerFactoryServlet.createEntityManager());
        setEntityTransaction(userDAO.getEntityManager().getTransaction());   
    }
    
    /**
     *
     * @param user
     * @return 
     */
    public User save(User user)
    {
        active();
        
        user.setId(null);
        user.setAuthorized(false);
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        userDAO.save(user);
        
        commit();
        
        userDAO.getEntityManager().close();
        
        return user;
    }

    /**
     *
     * @return 
     */
    public User update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return 
     */
    public User path() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}