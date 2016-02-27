/**
 * 
 */
package com.jccg.schedules.controllers;

import com.jccg.schedules.managers.UserManager;
import com.jccg.schedules.models.User;
import com.jccg.schedules.repositories.UserRepository;
import com.jccg.schedules.managers.filters.UserFilter;
import com.jccg.schedules.models.Category;
import com.jccg.schedules.resources.CategoryResource;
import com.jccg.schedules.resources.UserResource;
import com.jccg.schedules.resources.exception.DataNotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class UserController extends Controller
{    
    
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);
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
        LOGGER.info("All users");        
        return Response.ok(userRepository.all(userFilter)).build();
    }
    
    /**
     *
     * @param id
     * @return 
     */
    public Response find(Long id)
    {

        LOGGER.info("search User by id " + id);
        
        User user = userFind(id);
        
        LOGGER.info("Add link self");
        user.addLink(getUriInfo()
                .getBaseUriBuilder()
                .path(UserResource.class)
                .path(UserResource.class, "getUser")
                .resolveTemplate("id", id)
                .build()
                .toString()
                , "self");
        
        LOGGER.info("Add link category");
        user.addLink(getUriInfo()
                .getBaseUriBuilder()
                .path(CategoryResource.class)
                .path(CategoryResource.class, "getCategory")
                .resolveTemplate("id", user.getCategory().getId())
                .build()
                .toString()
                , "category");
        
        LOGGER.info("User with Category by name " + user.getCategory().getName());
        
        LOGGER.info("return user by id " + id);
        return Response.ok(user).build();
    }
    
    /**
     *
     * @param newUser
     * @return 
     */
    public Response create(User newUser)
    {
        LOGGER.info("Define category_id if is value null ");
        if(newUser.getCategoryId() == null)
            newUser.setCategoryId(1L);
        
        LOGGER.info("Search category with id " + newUser.getCategoryId());
        Category category = new CategoryController().categoryFind(newUser.getCategoryId());
        
        LOGGER.info("Set category with id " + newUser.getCategoryId());
        newUser.setCategory(category);
        
        LOGGER.info("Save new User");
        newUser = new UserManager().save(newUser);
        
        LOGGER.info("Return new create User with id " + newUser.getId());
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
        LOGGER.info("Update user by id " +  id);
        User user = userFind(id);
        
        LOGGER.info("Valid category by id " + updateUser.getCategoryId());
        if(updateUser.getCategoryId() != null)
            user.setCategory(new CategoryController().categoryFind(updateUser.getCategoryId()));
        
        LOGGER.info("Return user update");
        return Response.ok(new UserManager().merge(user, updateUser)).build();
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
     * @param id
     * @return 
     */
    public User userFind(Long id)
    {
        User user = userRepository.find(id);
        
        if(user == null)
            throw new DataNotFoundException("User with id " + id + " not found");
        
        return user;
    }
    
}
