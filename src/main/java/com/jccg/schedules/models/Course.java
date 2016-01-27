/**
 * 
 */
package com.jccg.schedules.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
@Entity
@Table(name="courses")
@XmlRootElement
public class Course extends Model
{
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
    private String name;
    
    /**
     *
     */
    public Course() 
    {
        super();
    }
    
    /**
     *
     * @param id
     * @param name
     */
    public Course(long id, String name) 
    {
        this();
        this.id = id;
        this.name = name;
    }
    
    /**
     *
     * @return 
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     *
     * @return 
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
}
