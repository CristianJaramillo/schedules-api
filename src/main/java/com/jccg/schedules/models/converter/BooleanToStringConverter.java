/**
 * 
 */
package com.jccg.schedules.models.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
@Converter
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

    public static final String YES = "Y";
    public static final String NO = "N";
    
    @Override
    public String convertToDatabaseColumn(Boolean x) {
        if (x == null) return null;
        else return x ? YES : NO;
    }

    @Override
    public Boolean convertToEntityAttribute(String y) {
        return YES.equals(y) ? Boolean.TRUE : Boolean.FALSE;
    }

}