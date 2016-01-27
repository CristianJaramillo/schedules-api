/**
 * 
 */
package com.jccg.schedules.managers;

import com.jccg.schedules.dao.EntityManagerFactoryServlet;
import com.jccg.schedules.dao.category.CategoryDAO;
import com.jccg.schedules.models.Category;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class CategoryManager extends Manager
{
    private static final Logger logger = LogManager.getLogger(CategoryManager.class);
    private final CategoryDAO categoryDAO;
            
    /**
     *
     */
    public CategoryManager()
    {
        categoryDAO = new CategoryDAO();
        categoryDAO.setEntityManager(EntityManagerFactoryServlet.createEntityManager());
        setEntityTransaction(categoryDAO.getEntityManager().getTransaction());
    }
    
    /**
     *
     * @param category
     * @return 
     */
    public Category save(Category category)
    {
        active();
        
        category.setId(null);
        category.setCreatedAt(new Date());
        category.setUpdatedAt(new Date());
        categoryDAO.save(category);
        commit();
        
        categoryDAO.getEntityManager().close();
        
        return category;
    }
    
}
