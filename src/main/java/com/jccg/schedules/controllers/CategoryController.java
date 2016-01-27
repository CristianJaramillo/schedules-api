/**
 * 
 */
package com.jccg.schedules.controllers;

import com.jccg.schedules.managers.CategoryManager;
import com.jccg.schedules.models.Category;
import com.jccg.schedules.repositories.CategoryRepository;
import com.jccg.schedules.managers.filters.CategoryFilter;
import javax.ws.rs.core.Response;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class CategoryController extends Controller
{
    private CategoryManager categoryManager;
    private CategoryRepository categoryRepository;
    
    
    /**
     *
     */
    public CategoryController()
    {
        
    }
    
    /**
     *
     * @param filter
     * @return
     */
    public Response all(CategoryFilter filter)
    {
        categoryRepository = new CategoryRepository();
        
        return Response.ok(categoryRepository.all(filter)).build();
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Response find(Long id)
    {
        categoryRepository = new CategoryRepository();
        
        return Response.ok(categoryRepository.find(id)).build();
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
       
    
}
