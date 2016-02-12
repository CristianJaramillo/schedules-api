/**
 * 
 */
package com.jccg.schedules.models.error;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author crist
 */
@XmlRootElement
public class UserError 
{
    @XmlAttribute(name="error_message")
    private String errorMessage;
    
    public UserError()
    {
    
    }
    
    /**
     *
     * @param errorMessage
     */
    public UserError(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    /**
     *
     * @return 
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     *
     * @param errorMessage
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
}
