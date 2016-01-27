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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
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
     * @param id
     * @return 
     */
    @GET
    @Path("{id}")
    public Response getCategory(@PathParam("id") Long id)
    {
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

//    /**
//     *
//     * @param id
//     * @param category
//     * @return 
//     */
//    @PUT
//    @Path("{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Category updateCategory(@PathParam("id") Long id, Category category)
//    {
//        category.setId(id);
//        
//        return (Category)service.update(category);
//    }
//    
//    /**
//     *
//     * @param id
//     * @return 
//     */
//    @DELETE
//    @Path("{id}")
//    public Category removeCategory(@PathParam("id") long id)
//    {
//        return (Category)service.remove(id);
//    }
    
}
