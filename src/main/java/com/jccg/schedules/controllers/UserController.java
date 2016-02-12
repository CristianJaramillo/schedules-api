/**
 * 
 */
package com.jccg.schedules.controllers;

import com.jccg.schedules.managers.UserManager;
import com.jccg.schedules.models.User;
import com.jccg.schedules.repositories.UserRepository;
import com.jccg.schedules.managers.filters.UserFilter;
import com.jccg.schedules.resources.CategoryResource;
import com.jccg.schedules.resources.UserResource;
import com.jccg.schedules.resources.exception.DataNotFoundException;
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
        User user = userRepository.find(id);
        
        if(user == null)
            throw new DataNotFoundException("User with id " + id + " not found");
        
        user.addLink(getUriInfo()
                .getBaseUriBuilder()
                .path(UserResource.class)
                .path(UserResource.class, "getUser")
                .resolveTemplate("id", id)
                .build()
                .toString()
                , "self");
        
        user.addLink(getUriInfo()
                .getBaseUriBuilder()
                .path(CategoryResource.class)
                .path(CategoryResource.class, "getCategory")
                .resolveTemplate("id", user.getCategoryId())
                .build()
                .toString()
                , "category");
        
        return Response.ok(user).build();
    }
    
    /**
     *
     * @param newUser
     * @return 
     */
    public Response create(User newUser)
    {
        // valida si tiene permisos asignación de role
        if(true)
            // en caso contrario asigna un roll por default
            newUser.setCategoryId(1L);
        
        newUser = new UserManager().save(newUser);
        
        return Response.created(getURILocation(newUser.getId()))
                .status(Status.CREATED)
                .entity(newUser)
                .build();
    }
    
    /**
     *
     * @param id
     * @param updateUser
     * @return 
     */
    public Response update(Long id, User updateUser)
    {
        return Response.ok(new UserManager().merge(updateUser, updateUser)).build();
    }

    /**
     * @param  id
     */
    public void delete(Long id)
    {
        new UserManager().delete(userFind(id));
    }

    /**
     *
     */
    private User userFind(Long id)
    {
        User user = userRepository.find(id);
        
        if(user == null)
            throw new DataNotFoundException("User with id " + id + " not found");
        
        return user;
    }
    
}
