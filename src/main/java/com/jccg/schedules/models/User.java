/**
 * 
 */
package com.jccg.schedules.models;

import javax.persistence.Column;
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
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "User.allByAuthorized", 
                           query = "from User u where u.authorized = :authorized")
})
@Table(name="users")
@XmlRootElement
public class User extends Model
{
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @XmlAttribute
    private Long id;
    @Column(name="full_name")
    @NotNull
    @XmlAttribute(name="full_name")
    private String fullName;
    @Email
    @NotNull
    @XmlAttribute
    private String email;
    @NotNull
    @XmlAttribute
    private String password;
    @XmlAttribute(name="category_id")
    private Long categoryId;
    @XmlAttribute
    private Boolean authorized;
    
    public User() 
    {
        super();
    }
    
    /**
     *
     * @param fullName
     * @param email
     * @param password
     */
    public User (String fullName, String email, String password)
    {
        this();
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.authorized = false;
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
     * @param fullName
     */
    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }
    
    /**
     *
     * @return
     */
    public String getFullName()
    {
        return fullName;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     *
     * @return 
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     *
     * @param password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    /**
     *
     * @return 
     */
    public String getPassword()
    {
        return password;
    }

    /**
     *
     * @return 
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     *
     * @param categoryId
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    
    /**
     *
     * @param authorized
     */
    public void setAuthorized(Boolean authorized)
    {
        this.authorized = authorized;
    }
    
    /**
     *
     * @return 
     */
    public Boolean getAuthorized()
    {
        return authorized;
    }
    
}
