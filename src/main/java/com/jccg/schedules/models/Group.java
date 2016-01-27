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
@Table(name="groups")
@XmlRootElement
public class Group extends Model
{
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
    private String name;
    
    /**
     *
     */
    public Group() 
    {
        super();
    }
    
    /**
     *
     * @param id
     * @param name
     */
    public Group(Long id, String name) 
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
        return name;
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
