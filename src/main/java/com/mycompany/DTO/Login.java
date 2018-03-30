/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DTO;

import com.mycompany.DTO.List.Officers;

/**
 *
 * @author shivangi
 */
public class Login 
{
    Officers OID;
    String EMAIL_ID;
    String PASSWORD;
    String TOKEN_ID;

    public Officers getOID() {
        return OID;
    }

    public void setOID(Officers OID) {
        this.OID = OID;
    }

    public String getEMAIL_ID() {
        return EMAIL_ID;
    }

    public void setEMAIL_ID(String EMAIL_ID) {
        this.EMAIL_ID = EMAIL_ID;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getTOKEN_ID() {
        return TOKEN_ID;
    }

    public void setTOKEN_ID(String TOKEN_ID) {
        this.TOKEN_ID = TOKEN_ID;
    }
   
}