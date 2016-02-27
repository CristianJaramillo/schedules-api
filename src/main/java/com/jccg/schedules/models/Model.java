/**
 * 
 */
package com.jccg.schedules.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
@MappedSuperclass
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Model implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 8997897772179927197L;
    
    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @XmlAttribute(name="created_at")
    protected Date createdAt;
    @Column(name="updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @XmlAttribute(name="updated_at")
    protected Date updatedAt;
    @Transient
    protected List<Link> links;
    
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
    
    /**
     *
     * @return 
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     *
     * @param links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }
    
    /**
     *
     * @param href
     * @param rel
     */
    public void addLink(String href, String rel)
    {
        if(links == null)
            links = new ArrayList<>();
        links.add(new Link(href, rel));
    }
    
}
