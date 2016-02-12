/**
 * 
 */
package com.jccg.schedules.controllers;

import com.jccg.schedules.managers.CategoryManager;
import com.jccg.schedules.models.Category;
import com.jccg.schedules.repositories.CategoryRepository;
import com.jccg.schedules.managers.filters.CategoryFilter;
import com.jccg.schedules.resources.CategoryResource;
import com.jccg.schedules.resources.exception.DataNotFoundException;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class CategoryController extends Controller
{
    private static final Logger logger = LogManager.getLogger(CategoryController.class);
    private final CategoryRepository categoryRepository;
    
    /**
     *
     */    
    public CategoryController()
    {
        categoryRepository = new CategoryRepository();
    }
    
    /**
     *
     * @param filter
     * @return
     */
    public Response all(CategoryFilter filter)
    {
        return Response.ok(categoryRepository.all(filter)).build();
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Response find(Long id)
    {
        Category category = categoryFind(id);
            
        category.addLink(getUriInfo()
                .getBaseUriBuilder()
                .path(CategoryResource.class)
                .path(CategoryResource.class, "getCategory")
                .resolveTemplate("id", id)
                .build()
                .toString()
                , "self");
        
        return Response.ok(category).build();
    }
    
    /**
     *
     * @param newCategory
     * @return 
     */
    public Response create(Category newCategory)
    {
        newCategory = new CategoryManager().save(newCategory);
        
        return Response.created(getURILocation(newCategory.getId()))
                .status(Response.Status.CREATED)
                .entity(newCategory)
                .build();
    }
    
    /**
     *
     * @param id
     * @param updateCategory
     * @return 
     */
    public Response update(Long id, Category updateCategory)
    {
        
        updateCategory = new CategoryManager().merge(categoryFind(id), updateCategory);
        
        return Response.ok(updateCategory).build();
    }
    
    /**
     *
     * @param id
     */
    public void delete(Long id)
    {
        new CategoryManager().delete(categoryFind(id));
    }
    
    /**
     *
     */
    private Category categoryFind(Long id)
    {
        Category category = categoryRepository.find(id);
        
        if(category == null)
            throw new DataNotFoundException("Category with id " + id + " not found");
        
        return category;
    }
    
}
