/**
 * 
 */
package com.jccg.schedules.resources.exception;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public class DataNotFoundException extends RuntimeException 
{
    /**
     *
     */
    private static final long serialVersionUID = -6762768769172192362L;
    
    public DataNotFoundException(String message)
    {
        super(message);
    }
    
}
