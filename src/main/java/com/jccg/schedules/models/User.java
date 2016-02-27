/**
 * 
 */
package com.jccg.schedules.models;

import com.jccg.schedules.models.converter.BooleanToStringConverter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
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
        @NamedQuery(name = "User.all", 
                           query = "from User u"),
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
    @Column(name="full_name", nullable = false)
    @NotNull
    @XmlAttribute(name="full_name")
    private String fullName;
    @Column(unique = true, nullable = false,  length=320)
    @Email
    @NotNull
    @XmlAttribute
    private String email;
    @Column(nullable=false, length=60)
    @NotNull
    @XmlAttribute
    private String password;
    @Transient
    @XmlAttribute(name="category_id")
    private Long categoryId;
    @JoinColumn(name="category_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Category category;
    @Convert(converter=BooleanToStringConverter.class)
    @XmlAttribute
    private Boolean authorized;
    
    public User() {}
    
    /**
     *
     * @param fullName
     * @param email
     * @param password
     */
    public User (String fullName, String email, String password)
    {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.authorized = Boolean.FALSE;
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
    public Category getCategory()
    {
        return category;
    }

    public Long getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }
    
    /**
     *
     * @param category
     */
    public void setCategory(Category category)
    {
        this.category = category;
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
