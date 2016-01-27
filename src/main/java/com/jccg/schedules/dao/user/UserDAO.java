/**
 * 
 */
package com.jccg.schedules.dao.user;

import com.jccg.schedules.dao.GenericDAO;
import com.jccg.schedules.models.User;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class UserDAO extends GenericDAO<User, Long> implements IUserDAO
{
    /**
     *
     */
    public UserDAO()
    {
        super(User.class);
    }
    
}
