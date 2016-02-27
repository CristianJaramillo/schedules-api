/**
 * 
 */
package com.jccg.schedules.repositories;

import com.jccg.schedules.dao.EntityManagerFactoryServlet;
import com.jccg.schedules.dao.category.CategoryDAO;
import com.jccg.schedules.models.Category;
import com.jccg.schedules.managers.filters.CategoryFilter;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class CategoryRepository extends Repository
{
    private static final Logger LOGGER = LogManager.getLogger(CategoryRepository.class);
    private final CategoryDAO categoryDAO;
    
    public CategoryRepository()
    {
        categoryDAO = new CategoryDAO();
        categoryDAO.setEntityManager(EntityManagerFactoryServlet.createEntityManager());
        super.setEntityTransaction(categoryDAO.getEntityManager().getTransaction());
    }
    
    public Category[] all(CategoryFilter categoryFilter)
    {
    
        active();
        
        TypedQuery<Category> query = categoryDAO.getEntityManager().createNamedQuery("Category.findAll", Category.class);
        
        query.setFirstResult(categoryFilter.getStart());
        query.setMaxResults(categoryFilter.getSize());
        
        List<Category> categories = query.getResultList();
        
        commit();
        
        categoryDAO.getEntityManager().close();
        
        for(Category category : categories)
            LOGGER.info("Category with id " + category.getId());
        
        return categories.toArray(new Category[categories.size()]);
    }
    
    public Category find(Long id)
    {
        active();
        
        Category category = categoryDAO.findById(id);
        
        commit();
        
        categoryDAO.getEntityManager().close();
        
        return category;
    }
    
}