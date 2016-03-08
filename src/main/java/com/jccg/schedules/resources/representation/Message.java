/**
 * 
 */
package com.jccg.schedules.resources.representation;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
@XmlRootElement
public class Message
{

    public Message() {
    }
    
    public Message(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    private String error;

}
