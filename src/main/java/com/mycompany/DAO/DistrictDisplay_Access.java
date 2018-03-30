package com.mycompany.DAO;

import com.mycompany.DTO.Action;
import com.mycompany.DTO.DistrictDisplay;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DistrictDisplay_Access
{
	public Map<String,DistrictDisplay> getDistrictDisplays(Connection con, Integer TOKEN_ID) throws SQLException
	{             
		Map<String,DistrictDisplay> actionMap = new HashMap<String,DistrictDisplay>();
                
                String SQL ="SELECT * FROM TASK where OID = (SELECT OID FROM OFFICER WHERE TOKEN_ID = "+TOKEN_ID+") ";
		PreparedStatement stmt = con.prepareStatement(SQL);
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				DistrictDisplay districtDisplayObj = new DistrictDisplay();
                                
//				districtDisplayObj.setActionId(rs.getInt("ACTION_ID"));
//				districtDisplayObj.setAction(rs.getString("ACTION"));
                                
				actionMap.put(rs.getString("DISTRICT"), districtDisplayObj);
			}
                        System.out.println("getall-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return actionMap;		
	}
}