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
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Consumes(value = {MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces(value = {MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
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
     * @param uriInfo
     * @param id
     * @return 
     */
    @GET
    @Path("{id}")
    public Response getUser(@Context UriInfo uriInfo, @PathParam("id") Long id)
    {
        userController.setUriInfo(uriInfo);
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
    
    /**
     *
     * @param id
     * @param user
     * @return 
     */
    @PUT
    @Path("{id}")
    public Response updateUser(@PathParam("id") Long id, @Valid User user)
    {
        return userController.update(id, user);
    }
    
    /**
     *
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void deleteUser(@PathParam("id") Long id)
    {
        userController.delete(id);
    }
    
}
