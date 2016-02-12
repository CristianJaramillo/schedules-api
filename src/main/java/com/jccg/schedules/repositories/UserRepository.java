/**
 * 
 */
package com.jccg.schedules.repositories;

import com.jccg.schedules.dao.EntityManagerFactoryServlet;
import com.jccg.schedules.dao.user.UserDAO;
import com.jccg.schedules.models.User;
import com.jccg.schedules.managers.filters.UserFilter;
import java.util.List;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class UserRepository extends Repository
{
    
    private static final Logger logger = LogManager.getLogger(UserRepository.class);
    private final UserDAO userDAO;
    
    /**
     *
     */
    public UserRepository()
    {
        userDAO = new UserDAO();
        userDAO.setEntityManager(EntityManagerFactoryServlet.createEntityManager());
        setEntityTransaction(userDAO.getEntityManager().getTransaction());   
    }
    
    public User[] all(UserFilter userFilter)
    {
    
        active();
    
        TypedQuery<User> query = userDAO.getEntityManager().createNamedQuery("User.allByAuthorized", User.class);
        
        query.setFirstResult(userFilter.getStart());
        query.setMaxResults(userFilter.getSize());
        
        query.setParameter("authorized", userFilter.getAuthorized());
        
        List<User> users = query.getResultList();
        
        commit();
        
        userDAO.getEntityManager().close();
        
        return users.toArray(new User[users.size()]);
    }
    
    public User find(Long id)
    {
        active();
        
        User user = userDAO.findById(id);
        
        commit();
        
        userDAO.getEntityManager().close();
        
        return user;
    }
    
}
