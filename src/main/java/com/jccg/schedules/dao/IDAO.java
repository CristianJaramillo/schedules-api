/**
 * 
 */
package com.jccg.schedules.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 * @param <T>
 * @param <ID>
 */
public interface IDAO <T, ID extends Serializable>
{
    T save(T entity);
    T update(T entity);
    void delete(T entity);
    T findById(ID id);
    List<T> findAll();
    void flush();
    
}
