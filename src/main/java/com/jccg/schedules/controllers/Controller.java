/**
 * 
 */
package com.jccg.schedules.controllers;

import java.net.URI;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public abstract class Controller 
{
    private UriInfo uriInfo;
    
    public UriInfo getUriInfo() {
        return uriInfo;
    }

    public void setUriInfo(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }
    
    /**
     *
     * @param id
     * @return 
     */
    public URI getURILocation(Long id)
    {
        return getUriInfo().getAbsolutePathBuilder()
                .path(String.valueOf(id))
                .build();
    }
    
}
