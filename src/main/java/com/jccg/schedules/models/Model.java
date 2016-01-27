/**
 * 
 */
package com.jccg.schedules.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
@MappedSuperclass
@XmlAccessorType(XmlAccessType.FIELD)
public class Model implements Serializable
{
    
    private static final long serialVersionUID = 8997897772179927197L;
    
    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @XmlAttribute(name="created_at")
    private Date createdAt;
    @Column(name="updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @XmlAttribute(name="updated_at")
    private Date updatedAt;
    
    public Model()
    {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    
    /**
     * @param createdAt
     */
    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }
    
    /**
     * @return
     */
    public Date getCreatedAt()
    {
        return this.createdAt;
    }
    
    /**
     * @param updatedAt
     */
    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }
    
    /**
     * @return
     */
    public Date getUpdatedAt()
    {
        return this.updatedAt;
    }
    
}
