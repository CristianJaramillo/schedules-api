/**
 * 
 */
package com.jccg.schedules.resources;

import com.jccg.schedules.controllers.CategoryController;
import com.jccg.schedules.models.Category;
import com.jccg.schedules.managers.filters.CategoryFilter;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
@Path("categories")
@Consumes(value = {MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces(value = {MediaType.TEXT_XML, MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CategoryResource extends Resource
{
    
    private final CategoryController categoryController;

    /**
     *
     */
    public CategoryResource()
    {
    	categoryController = new CategoryController();
    }

    /**
     *
     * @param filter
     * @return
     */
    @GET
    public Response getCategories(@BeanParam CategoryFilter filter)
    {
	return categoryController.all(filter);
    }

    /**
     *
     * @param uriInfo
     * @param id
     * @return 
     */
    @GET
    @Path("{id}")
    public Response getCategory(@Context UriInfo uriInfo, @PathParam("id") Long id)
    {
        categoryController.setUriInfo(uriInfo);
        return categoryController.find(id);
    }
    
    /**
     *
     * @param uriInfo
     * @param category
     * @return
     */
    @POST
    public Response addCategory(@Context UriInfo uriInfo, @Valid Category category)
    {
        categoryController.setUriInfo(uriInfo);        
        return categoryController.create(category);
    } 

    /**
     *
     * @param id
     * @param updateCategory
     * @return 
     */
    @PUT
    @Path("{id}")
    public Response updateCategory(@PathParam("id") Long id, Category updateCategory)
    {
        return categoryController.update(id, updateCategory);
    }
    
    /**
     *
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void deleteCategory(@PathParam("id") long id)
    {
        categoryController.delete(id);
    }
    
}
