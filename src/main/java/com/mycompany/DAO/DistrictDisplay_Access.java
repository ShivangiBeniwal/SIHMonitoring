package com.mycompany.DAO;

import com.mycompany.DTO.Action;
import com.mycompany.DTO.Address;
import com.mycompany.DTO.DistrictDisplay;
import com.mycompany.DTO.List.Visits;
import com.mycompany.DTO.Task;
import com.mycompany.DTO.Visit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DistrictDisplay_Access
{
	public Map<String,DistrictDisplay> getDistrictDisplays(Connection con, Integer TOKEN_ID) throws SQLException
	{             
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Map<String,DistrictDisplay> actionMap = new HashMap<String,DistrictDisplay>();
                
		try
		{                   
                
                String SQL ="SELECT * FROM TASK where OID = (SELECT OID FROM OFFICER WHERE TOKEN_ID = "+TOKEN_ID+") ";
		PreparedStatement stmt = con.prepareStatement(SQL);
		ResultSet rs = stmt.executeQuery();
                
                        DistrictDisplay districtDisplayObj = new DistrictDisplay();                        
			while(rs.next())
			{         
                                ArrayList<Task> taskList = new ArrayList<Task>();
                                Task taskObj = new Task();
                                Programme_Access pa = new Programme_Access();
                                Officer_Access oa = new Officer_Access();
                                Address_Access aa = new Address_Access();
                                Status_Access sa = new Status_Access();
                                
				taskObj.setTid(rs.getInt("TID"));
                                taskObj.setPid(pa.getProgramme(con, rs.getInt("PID")));
                                taskObj.setOid(oa.getOfficer(con, rs.getInt("OID")));
                                
                                Address add = aa.getAddress(con, rs.getInt("AID"));
                                taskObj.setAid(add);
                                taskObj.setStatusId(sa.getStatus(con, rs.getInt("STATUS_ID")));
				taskObj.setDescription(rs.getString("DESCRIPTION"));
				taskObj.setSetDate(dateFormat.format(new Date(rs.getDate("SET_DATE").getTime())));
				taskObj.setDeadline(dateFormat.format(new Date(rs.getDate("DEADLINE").getTime())));
                                taskObj.setVisitType(rs.getString("VISIT_TYPE"));
                                
                                
                                String District_Name = add.getDistrict();                                
                                if(!actionMap.containsKey(District_Name))
                                {
                                    taskList.add(taskObj);
                                    districtDisplayObj.setTask(taskList);
                                    
				    actionMap.put(District_Name, districtDisplayObj);
                                }
                                else
                                {
                                    DistrictDisplay t = actionMap.get(District_Name);
                                    ArrayList<Task> taskL = t.getTask();
                                    taskL.add(taskObj);
                                    
                                    districtDisplayObj.setTask(taskList);
                                    
				    actionMap.put(District_Name, districtDisplayObj);
                                }                                    
			}
                        System.out.println("getall-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return actionMap;		
	}
        
        public Visits findVisitByTID(Connection con, int TID) throws SQLException
        {
            Visits vs = new Visits();
            ArrayList<Visit> vlist = new ArrayList<Visit>();
            
            try
            {
                String SQL ="SELECT * FROM Visits where TID = "+TID;
		PreparedStatement stmt = con.prepareStatement(SQL);
		ResultSet rs = stmt.executeQuery();
                
                while(rs.next())
			{
                            Visit v = new Visit();
                                Task_Access ta = new Task_Access();
                                Action_Access aa = new Action_Access();
                                
				v.setVid(rs.getInt("VID"));
                                v.setTid(ta.getTask(con, rs.getInt("TID")));
                                v.setActionId(aa.getAction(con, rs.getInt("ACTION_ID")));
                                v.setPicture(rs.getString("PICTURE"));
                                v.setLat(rs.getBigDecimal("LAT"));
                                v.setLongitude(rs.getBigDecimal("LONGITUDE"));
                                v.setRemarkOfficer(rs.getString("REMARK_OFFICER"));
                                v.setRemarkAdmin(rs.getString("REMARK_ADMIN"));   
                                
                                vlist.add(v);
			}
                
                vs.setVisitList(vlist);
            }
            catch(Exception e)
            {
                System.err.println(e);
            }            
            
            return vs;
        }
}