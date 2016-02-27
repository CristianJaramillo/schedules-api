/**
 * 
 */
package com.jccg.schedules.repositories;

import com.jccg.schedules.dao.EntityManagerFactoryServlet;
import com.jccg.schedules.dao.user.UserDAO;
import com.jccg.schedules.models.User;
import com.jccg.schedules.managers.filters.UserFilter;
import java.util.List;
import java.util.Objects;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class UserRepository extends Repository
{
    
    private static final Logger LOGGER = LogManager.getLogger(UserRepository.class);
    private final UserDAO userDAO;
    
    /**
     *
     */
    public UserRepository()
    {
        userDAO = new UserDAO();
        userDAO.setEntityManager(EntityManagerFactoryServlet.createEntityManager());
        super.setEntityTransaction(userDAO.getEntityManager().getTransaction());
    }
    
    /**
     *
     * @param userFilter
     * @return 
     */
    public User[] all(UserFilter userFilter)
    {
        TypedQuery<User> query;
        List<User> users;
        
        active();
        
        if(userFilter.getAuthorized() == null) {
            LOGGER.info("Create query by name User.all");
            query = userDAO.getEntityManager().createNamedQuery("User.all", User.class);
        } else {
            LOGGER.info("Create query by name User.allByAuthorized");
            query = userDAO.getEntityManager().createNamedQuery("User.allByAuthorized", User.class);
            
            LOGGER.info("Query set authorized parameter " + userFilter.getAuthorized());
            query.setParameter("authorized", userFilter.getAuthorized());
        }
        
        LOGGER.info("User start " +  userFilter.getStart());
        query.setFirstResult(userFilter.getStart());
        
        LOGGER.info("User size " + userFilter.getSize());
        query.setMaxResults(userFilter.getSize());
        
        LOGGER.info("Load results");
        users = query.getResultList();
        
        commit();
        
        userDAO.getEntityManager().close();
        
        for(User user : users)
            LOGGER.info("User with id " + user.getId());
        
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
