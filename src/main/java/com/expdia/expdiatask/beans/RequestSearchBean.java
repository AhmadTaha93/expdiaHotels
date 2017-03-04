/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.expdia.expdiatask.beans;

/**
 *
 * @author ahmad
 */
public class RequestSearchBean {
    
    private String  city;
    private String startDate;
    private String endDate;

    public String getCity() {
        return city;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "RequestSearchBean{" + "city=" + city + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }
    
    
    
    
}
