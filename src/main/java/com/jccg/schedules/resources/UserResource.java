/**
 * 
 */
package com.jccg.schedules.resources;

import com.jccg.schedules.controllers.UserController;
import com.jccg.schedules.models.User;
import com.jccg.schedules.managers.filters.UserFilter;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource extends Resource
{        
    
    private final UserController  userController;
    
    public UserResource()
    {
        userController = new UserController();   
    }
    
    /**
     * @param filter
     * @return
     */
    @GET
    public Response getUsers(@BeanParam UserFilter filter)
    {        
        return userController.all(filter);
    }

    /**
     *
     * @param id
     * @return 
     */
    @GET
    @Path("{id}")
    public Response getUser(@PathParam("id") Long id)
    {
        return userController.find(id);
    }
    
    /**
     *
     * @param uriInfo
     * @param user
     * @return
     */
    @POST
    public Response addUser(@Context UriInfo uriInfo, @Valid User user)
    {
        userController.setUriInfo(uriInfo);
        
        return userController.create(user);
    }   
    
}
