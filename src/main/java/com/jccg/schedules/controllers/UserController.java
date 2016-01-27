/**
 * 
 */
package com.jccg.schedules.controllers;

import com.jccg.schedules.managers.UserManager;
import com.jccg.schedules.models.User;
import com.jccg.schedules.repositories.UserRepository;
import com.jccg.schedules.managers.filters.UserFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class UserController extends Controller
{    
    private final UserRepository userRepository;
    
    /**
     *
     */
    public UserController()
    {
        userRepository = new UserRepository();
    }
    
    public Response all(UserFilter userFilter)
    {
        return Response.ok(userRepository.all(userFilter)).build();
    }
    
    public Response find(Long id)
    {
        return Response.ok(userRepository.find(id)).build();
    }
    
    /**
     *
     * @param newUser
     * @return 
     */
    public Response create(User newUser)
    {
        
        newUser = new UserManager().save(newUser);
        
        return Response.created(getURILocation(newUser.getId()))
                .status(Status.CREATED)
                .entity(newUser)
                .build();
    }
    
}
