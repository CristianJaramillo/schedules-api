/**
 * 
 */
package com.jccg.schedules.models;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class Link 
{
    
    private String href;
    private String rel;
    
    /**
     *
     */
    public Link() {}
    
    /**
     *
     * @param href
     * @param rel
     */
    public Link(String href, String rel)
    {
        this.href = href;
        this.rel = rel;
    }

    /**
     *
     * @return 
     */
    public String getHref() {
        return href;
    }

    /**
     *
     * @param href
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     *
     * @return 
     */
    public String getRel() {
        return rel;
    }

    /**
     *
     * @param rel
     */
    public void setRel(String rel) {
        this.rel = rel;
    }

}
