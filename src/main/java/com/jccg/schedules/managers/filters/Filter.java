/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jccg.schedules.managers.filters;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
public abstract class Filter 
{
    private @DefaultValue("0") @QueryParam("start") int start;
    private @DefaultValue("30") @QueryParam("size") int size;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
