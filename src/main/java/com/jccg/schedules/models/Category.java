/**
 * 
 */
package com.jccg.schedules.models;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
    @Column(unique = true)
    @XmlAttribute
    @NotNull
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch=FetchType.LAZY)
    @OrderBy("id")
    private Set<User> users;
    
    /**
     *
     */
    public Category() {}
    
    /**
     *
     * @param name
     */
    public Category(String name) 
    {
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
    
    /**
     *
     * @return 
     */
    public Set<User> getUsers()
    {
        return users;
    }

    /**
     * 
     * @param users
     */
    public void setUsers(Set<User> users)
    {
        this.users = users;
    }
    
    /**
     *
     * @param user
     */
    public void addUser(User user)
    {
        users.add(user);
        user.setCategory(this);
    }

    /**
     *
     * @param user
     */
    public void removeChild(User user)
    {
        users.remove(user);
        user.setCategory(null);
    }
}
