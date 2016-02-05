/**
 * 
 */
package com.jccg.schedules.resources.filter.request;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class AuthorizationRequestFilter implements ContainerRequestFilter {
 
    private static final Logger logger = LogManager.getLogger(AuthorizationRequestFilter.class);
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException
    {
        logger.info(AuthorizationRequestFilter.class);
    }
}
