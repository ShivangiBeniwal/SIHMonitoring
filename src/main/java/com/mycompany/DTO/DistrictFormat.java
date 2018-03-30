/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DTO;

/**
 *
 * @author shivangi
 */
public class DistrictFormat 
{
    String Name;
    Integer Assigned, Completed, Pending, VisitCount;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Integer getAssigned() {
        return Assigned;
    }

    public void setAssigned(Integer Assigned) {
        this.Assigned = Assigned;
    }

    public Integer getCompleted() {
        return Completed;
    }

    public void setCompleted(Integer Completed) {
        this.Completed = Completed;
    }

    public Integer getPending() {
        return Pending;
    }

    public void setPending(Integer Pending) {
        this.Pending = Pending;
    }

    public Integer getVisitCount() {
        return VisitCount;
    }

    public void setVisitCount(Integer VisitCount) {
        this.VisitCount = VisitCount;
    }
}