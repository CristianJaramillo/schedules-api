/**
 * 
 */
package com.jccg.schedules.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
@Entity
@NamedQueries({
    @NamedQuery( name="Category.findAll", query = "from Category c" )
})
@Table(name="categories")
@XmlRootElement
public class Category extends Model
{
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @XmlAttribute
    private Long id;
    @XmlAttribute
    @NotNull
    private String name;
    
    /**
     *
     */
    public Category() 
    {
        super();
    }
    
    /**
     *
     * @param name
     */
    public Category(String name) 
    {
        this();
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
