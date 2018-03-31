package com.mycompany.DAO;

import com.mycompany.DTO.Officer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Officer_Access
{
	public Map<Integer,Officer> getOfficers(Connection con) throws SQLException
	{
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
		Map<Integer,Officer> officerMap = new HashMap<Integer,Officer>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM OFFICER");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				Officer officerObj = new Officer();                
				officerObj.setOid(rs.getInt("OID"));
				officerObj.setName(rs.getString("NAME"));
				officerObj.setEmailId(rs.getString("EMAIL_ID"));
				officerObj.setMobile(rs.getInt("MOBILE"));
				officerObj.setAadharCard(rs.getInt("AADHAR_CARD"));
                                officerObj.setPassword(rs.getString("PASSWORD"));
                                officerObj.setTokenId(rs.getString("TOKEN_ID"));
				officerObj.setDoj(dateFormat.format(new Date(rs.getDate("DOJ").getTime())));
				officerObj.setRtd(dateFormat.format(new Date(rs.getDate("RTD").getTime())));
                                officerObj.setAdminRights(rs.getString("ADMIN_RIGHTS"));
                                
				officerMap.put(rs.getInt("OID"), officerObj);
			}
                        System.out.println("getall-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return officerMap;		
	}
        
	public Officer getOfficer(Connection con, int OID) throws SQLException
	{
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
                Officer officerObj = new Officer();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM OFFICER where OID = "+OID);
		ResultSet rs = stmt.executeQuery();
                
		try
		{
			while(rs.next())
                        {                                 
				officerObj.setOid(rs.getInt("OID"));
				officerObj.setName(rs.getString("NAME"));
				officerObj.setDesignation(rs.getString("DESIGNATION"));
				officerObj.setEmailId(rs.getString("EMAIL_ID"));
				officerObj.setMobile(rs.getInt("MOBILE"));
				officerObj.setAadharCard(rs.getInt("AADHAR_CARD"));
                                officerObj.setPassword(rs.getString("PASSWORD"));
                                officerObj.setTokenId(rs.getString("TOKEN_ID"));
				officerObj.setDoj(dateFormat.format(new Date(rs.getDate("DOJ").getTime())));
				officerObj.setRtd(dateFormat.format(new Date(rs.getDate("RTD").getTime())));
                                officerObj.setAdminRights(rs.getString("ADMIN_RIGHTS"));
			}
                        System.out.println("get-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return officerObj;		
	}
        
	public void addOfficer(Connection con, Officer o) throws SQLException
	{
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String SQL_QUERY = "insert into OFFICER values(?,?,?,?,?,?,?,?,?,?,?)";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setInt(1, o.getOid());
                pst.setString(2, o.getName());
                pst.setString(3, o.getDesignation());
                pst.setString(4, o.getEmailId());
                pst.setInt(5, o.getMobile());
                pst.setInt(6, o.getAadharCard());
                pst.setString(7, o.getPassword());
                
                String tokenid = UUID.randomUUID().toString();
                pst.setString(8, tokenid);
                pst.setTimestamp(9, new Timestamp(dateFormat.parse(o.getDoj()).getTime()));
                pst.setTimestamp(10, new Timestamp(dateFormat.parse(o.getRtd()).getTime()));                
                pst.setString(11, o.getAdminRights());
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" add-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }		
	}
        
	public void updateOfficer(Connection con, int OID, Officer o) throws SQLException
	{
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String SQL_QUERY = "update OFFICER set NAME = ?, DESIGNATION = ?, EMAIL_ID = ?, MOIBILE = ?, "
                    + "AADHAR_CARD = ?, PASSWORD = ?, TOKEN_ID = ? ,DOJ = ?, RTD = ?, ADMIN_RIGHTS = ?  where OID = ?";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setString(1, o.getName());
                pst.setString(2, o.getDesignation());
                pst.setString(3, o.getEmailId());
                pst.setInt(4, o.getMobile());
                pst.setInt(5, o.getAadharCard());
                pst.setString(6, o.getPassword());
                pst.setString(7, o.getTokenId());
                pst.setTimestamp(8, new Timestamp(dateFormat.parse(o.getDoj()).getTime()));
                pst.setTimestamp(9, new Timestamp(dateFormat.parse(o.getRtd()).getTime()));                
                pst.setString(10, o.getAdminRights());
                pst.setInt(11, OID);
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" update-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }		
	}
                
	public void deleteOfficer(Connection con, int OID) throws SQLException
	{
            String SQL_QUERY = "delete from OFFICER where OID = "+OID;
            try
            {
                Statement smt = con.createStatement(); 
                int rowCount = smt.executeUpdate(SQL_QUERY);
                
                System.out.println(rowCount+" delete-----Access");
            } 
            catch (SQLException e)
	    {		
                e.printStackTrace();
            }		
	}

    public Officer loginOfficer(Connection con, String email,String pass) 
    {
        
           Officer feedObject = new Officer();
           try{
               
               PreparedStatement ps = con.prepareStatement("SELECT OID, PASSWORD from OFFICER where EMAIL_ID = '"+email+"'" );
               ResultSet rs = ps.executeQuery();
                       
			while(rs.next())
			{
                            int OID= rs.getInt("OID");
                            String actualpass= rs.getString("PASSWORD");
                            
                            if(pass.equals(actualpass))
                            {
                                String tokenid = UUID.randomUUID().toString();
                                PreparedStatement pst = con.prepareStatement( "update OFFICER set TOKEN_ID = '"+tokenid+"' where EMAIL_ID = '"+email+"' ");
                                pst.executeUpdate();                                
                                
                                feedObject = getOfficer(con, OID);
                                feedObject.setTokenId(tokenid);
                            }
                            else
                            {
                                feedObject.setTokenId("");
                            }
                        }
           }
           catch (SQLException e)
	    {		
                e.printStackTrace();
            }
           
           return feedObject;
    }
    
    public Officer signUpOfficer(Connection con, String userid , String password , String name) throws SQLException
	{

            String SQL_QUERY = "select EMAIL_ID from OFFICER where EMAIL_ID = '"+userid + "'";
            Officer officerObj = new Officer();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");  
                
            try
            {
                Statement smt = con.createStatement(); 
                ResultSet rs  = smt.executeQuery(SQL_QUERY);
                String tokenid = UUID.randomUUID().toString();
               
                if(rs.next()){
                    System.out.println(" Already present");
                    
                }else{
                     String query = "insert into  OFFICER(EMAIL_ID , PASSWORD , TOKEN_ID, NAME ) values ('"+userid+"' , '"+password+"' , '"+tokenid+"' , '"+name+"' )";  
                     Statement sm = con.createStatement(); 
                     
                     sm.executeUpdate(query);
                     
                     
               PreparedStatement ps = con.prepareStatement("SELECT * from OFFICER where EMAIL_ID = '"+userid+"'" );
               ResultSet rs1 = ps.executeQuery();
                       
			while(rs1.next())

			{                            
                                Office_Access oa = new Office_Access();

				officerObj.setOid(rs1.getInt("OID"));
				officerObj.setName(rs1.getString("NAME"));
				officerObj.setEmailId(rs1.getString("EMAIL_ID"));
				officerObj.setMobile(rs1.getInt("MOBILE"));
				officerObj.setAadharCard(rs1.getInt("AADHAR_CARD"));
                                officerObj.setPassword(rs1.getString("PASSWORD"));
                                officerObj.setTokenId(rs1.getString("TOKEN_ID"));
				officerObj.setDoj(dateFormat.format(new Date().getTime()));
				officerObj.setRtd(dateFormat.format(new Date().getTime()));

                                officerObj.setAdminRights(rs1.getString("ADMIN_RIGHTS"));
                        }                    
                }
            } 
            catch (SQLException e)
	    {		
                e.printStackTrace();
            }
            return officerObj;
	}

    public void gcmUpdate(Connection con, int id, String token) 
    {
        String SQL_QUERY = "update OFFICER set GCM_TOKEN = ? where OID = ?";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setString(1, token);
                pst.setInt(2, id);
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" update-----Access");
            } 
            catch (Exception e)
	    {		
                e.printStackTrace();
            }	
    }
}