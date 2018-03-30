package com.mycompany.Model;

import com.mycompany.DAO.Database;
import com.mycompany.DAO.DistrictDisplay_Access;
import com.mycompany.DTO.DistrictDisplay;
import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;

public class DistrictDisplay_AccessManager
{
	public Map<String,DistrictDisplay> getDistrictDisplays(Integer id) throws Exception
	{
            Map<String,DistrictDisplay> actionMap = new HashMap<String,DistrictDisplay>();
            
            Database db = new Database();
            Connection con = db.getConnection();
            DistrictDisplay_Access access = new DistrictDisplay_Access();
            
            actionMap = access.getDistrictDisplays(con, id);
            System.out.println("getall----AccessManager");
            
            return actionMap;
	}
}