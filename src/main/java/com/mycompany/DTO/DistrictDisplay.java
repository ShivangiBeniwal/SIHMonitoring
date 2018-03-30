/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DTO;

import java.util.ArrayList;

/**
 *
 * @author shivangi
 */
public class DistrictDisplay 
{
    String Name;
    ArrayList<Task> Assigned;
    ArrayList<Task> Complete;    
    ArrayList<Visit> Visits;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public ArrayList<Task> getAssigned() {
        return Assigned;
    }

    public void setAssigned(ArrayList<Task> Assigned) {
        this.Assigned = Assigned;
    }

    public ArrayList<Task> getComplete() {
        return Complete;
    }

    public void setComplete(ArrayList<Task> Complete) {
        this.Complete = Complete;
    }

    public ArrayList<Visit> getVisits() {
        return Visits;
    }

    public void setVisits(ArrayList<Visit> Visits) {
        this.Visits = Visits;
    }
    
    
}
