/**
 * 
 */
package com.jccg.schedules.resources.exception.provider;

import com.jccg.schedules.resources.exception.DataNotFoundException;
import com.jccg.schedules.resources.representation.Message;
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
        return Response.ok(new Message(ex.getMessage()))
                .status(Status.NOT_FOUND)
                .build();
    }
    
}
