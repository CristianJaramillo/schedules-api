/**
 * 
 */
package com.jccg.schedules.managers.filters;

import javax.ws.rs.QueryParam;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class UserFilter extends Filter
{

    public Boolean getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Boolean authorized) {
        this.authorized = authorized;
    }
    
    private @QueryParam("authorized") Boolean authorized;
}
