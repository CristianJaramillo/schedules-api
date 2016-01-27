/**
 * 
 */
package com.jccg.schedules.dao.category;

import com.jccg.schedules.dao.GenericDAO;
import com.jccg.schedules.models.Category;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class CategoryDAO extends GenericDAO<Category, Long> implements ICategoryDAO
{
    /**
     *
     */
    public CategoryDAO()
    {
        super(Category.class);
    }
    
}
