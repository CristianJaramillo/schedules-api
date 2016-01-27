/**
 * 
 */
package com.jccg.schedules.resources.filter.response;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class PoweredByResponseFilter implements ContainerResponseFilter {
 
    private final Logger logger = LogManager.getLogger(PoweredByResponseFilter.class.getName());
    
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
            logger.info("PoweredByResponseFilter");
            responseContext.getHeaders().add("X-Powered-By", "Jersey :-)");
    }
    
}
