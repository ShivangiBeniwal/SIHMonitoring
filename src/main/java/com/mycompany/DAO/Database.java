package com.mycompany.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database
{
    
    Connection connection;
    
   
	public Connection getConnection() throws Exception
	{
            
            if(connection!= null){
                return connection;
            }
		try
		{
			String connectionURL = "jdbc:mysql://localhost:3306/FINAL_DB";
			connection = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "system");
                        System.out.println("--------DB");
			return connection;
		} catch (Exception e)
		{
			throw e;
		}
		
	}

}