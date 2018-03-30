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
public class SignUp 
{
    public String Name;
    public String Email_Id;
    public String Token_Id;
    public String Password;

    public String getName() {
        return Name;
    }

    public String getEmailId() {
        return Email_Id;
    }

    public String getTokenId() {
        return Token_Id;
    }

    public String getPassword() {
        return Password;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setEmailId(String Email_Id) {
        this.Email_Id = Email_Id;
    }

    public void setTokenId(String Token_Id) {
        this.Token_Id = Token_Id;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
