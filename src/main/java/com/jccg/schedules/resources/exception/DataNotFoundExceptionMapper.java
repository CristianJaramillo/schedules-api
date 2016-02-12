/**
 * 
 */
package com.jccg.schedules.resources.exception;

import com.jccg.schedules.models.error.UserError;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author crist
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>
{

    /**
     *
     * @param ex
     * @return
     */
    @Override
    public Response toResponse(DataNotFoundException ex)
    {        
        return Response.status(Status.NOT_FOUND)
                .entity(new UserError(ex.getMessage()))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
}
