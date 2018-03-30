package com.mycompany.Model;

import com.mycompany.DAO.Database;
import com.mycompany.DAO.Officer_Access;
import com.mycompany.DTO.Login;
import com.mycompany.DTO.Officer;
import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;

public class Officer_AccessManager
{
	public Map<Integer,Officer> getOfficers() throws Exception
	{
		Map<Integer,Officer> officerMap = new HashMap<Integer,Officer>();
                
		Database db = new Database();
		Connection con = db.getConnection();
		Officer_Access access = new Officer_Access();
                
		officerMap = access.getOfficers(con);
                System.out.println("getall----AccessManager");
                
		return officerMap;
	}
        
        public void addOfficer(Officer o) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Officer_Access access = new Officer_Access();
                
                access.addOfficer(con, o);
                System.out.println("add----AccessManager");
        }        
        
        public void updateOfficer(int OID, Officer o) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Officer_Access access = new Officer_Access();
                
                access.updateOfficer(con, OID, o);
                System.out.println("update----AccessManager");
        }
        
        public void deleteOfficer(int OID) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Officer_Access access = new Officer_Access();
                
                access.deleteOfficer(con, OID);
                System.out.println("delete----AccessManager");
        }
        
        public Officer Login(Login login)throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Officer_Access access = new Officer_Access();
                
                return access.loginOfficer(con, login);
//                System.out.println("login----AccessManager");
        }
        
        public Officer signUpOfficer(String userid , String pass , String name) throws Exception
        {
		Database db = new Database();
		Connection con = db.getConnection();
		Officer_Access access = new Officer_Access();
                
                return access.signUpOfficer(con, userid , pass , name);
//                System.out.println("signup----AccessManager");
        }
}