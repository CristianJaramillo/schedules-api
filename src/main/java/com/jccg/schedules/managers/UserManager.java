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

    private static final Logger LOGGER = LogManager.getLogger(UserManager.class);
    private final UserDAO userDAO;
    
    /**
     *
     */
    public UserManager()
    {
        userDAO = new UserDAO();
        userDAO.setEntityManager(EntityManagerFactoryServlet.createEntityManager());
        super.setEntityTransaction(userDAO.getEntityManager().getTransaction());   
    }
    
    /**
     *
     * @param user
     * @return 
     */
    public User save(User user)
    {
        user.setId(null);
        user.setCategoryId(null);
        user.setAuthorized(Boolean.FALSE);
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        user.setLinks(null);
        
        active();
        
        userDAO.save(user);
        
        commit();
        
        userDAO.getEntityManager().close();
        
        return user;
    }
    
    /**
     *
     * @param user
     * @param updateUser
     * @return 
     */
    public User merge(User user, User updateUser)
    {
        LOGGER.info("Set update user data");
        user.setFullName(updateUser.getFullName());
        user.setEmail(updateUser.getEmail());
        user.setPassword(updateUser.getPassword());        
        Boolean authorized = updateUser.getAuthorized() == null ? user.getAuthorized() : updateUser.getAuthorized();
        user.setAuthorized(authorized);        
        user.setUpdatedAt(new Date());
        
        active();
        
        LOGGER.info("Save changes user");
        userDAO.update(user);
        
        commit();
        
        userDAO.getEntityManager().close();
        
        LOGGER.info("Resturn user update");
        return user;
    }
    
    /**
     * 
     * @param user
     */
    public void delete(User user)
    {
        active();
        
        userDAO.delete(user);
        
        commit();
        
        userDAO.getEntityManager().close();
    }
    
}
