package com.mycompany.DAO;

import com.mycompany.DTO.Options;
import com.mycompany.DTO.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Question_Access
{
	public Map<Integer,Question> getQuestions(Connection con) throws SQLException
	{
		Map<Integer,Question> questionMap = new HashMap<Integer,Question>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM QUESTION");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				Question questionObj = new Question();
                                Programme_Access pa = new Programme_Access();
                                Integer QID = rs.getInt("QID");
                                
				questionObj.setQid(QID);
                                questionObj.setQuestion(rs.getString("QUESTION"));
                                questionObj.setDescription(rs.getString("DESCRIPTION"));
                                questionObj.setFormat(rs.getString("FORMAT"));
                                questionObj.setPid(pa.getProgramme(con, rs.getInt("PID")));
                                questionObj.setVisitType(rs.getString("VISIT_TYPE"));
                                questionObj.setRequired(rs.getShort("REQUIRED"));
                                
				questionMap.put(QID, questionObj);
			}
                        System.out.println("getall-----Access");
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return questionMap;		
	}
        
	public Question getQuestion(Connection con, int QID) throws SQLException
	{
                Question questionObj = new Question();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM QUESTION where QID = "+QID);
		ResultSet rs = stmt.executeQuery();
                
		try
		{
			while(rs.next())
			{
                                Programme_Access pa = new Programme_Access();
                                
				questionObj.setQid(QID);
                                questionObj.setQuestion(rs.getString("QUESTION"));
                                questionObj.setDescription(rs.getString("DESCRIPTION"));
                                questionObj.setFormat(rs.getString("FORMAT"));
                                questionObj.setPid(pa.getProgramme(con, rs.getInt("PID")));
                                questionObj.setVisitType(rs.getString("VISIT_TYPE"));
                                questionObj.setRequired(rs.getShort("REQUIRED"));
			}
                        System.out.println("get-----Access");
		} 
                catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return questionObj;		
	}
        
	public void addQuestion(Connection con, Question qs) throws SQLException
	{
            String SQL_QUERY = "insert into QUESTION values(?,?,?,?,?)";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setString(1, qs.getQuestion());
                pst.setString(2, qs.getDescription());
                pst.setString(3, qs.getFormat());
                pst.setInt(4, qs.getPid().getPid());
                pst.setString(5, qs.getVisitType());
                pst.setShort(6, qs.getRequired());
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" add-----Access");
            } 
            catch (SQLException e)
	    {		
                e.printStackTrace();
            }		
	}
        
	public void updateQuestion(Connection con, int QID, Question qs) throws SQLException
	{
            String SQL_QUERY = "update QUESTION set QUESTION = ?, DESCRIPTION = ?, FORMAT = ?, PID = ?, "
                    + "VISIT_TYPE = ?, REQUIRED = ? where QID = ?";
            try
            {
                PreparedStatement pst = con.prepareStatement(SQL_QUERY);
                pst.setString(1, qs.getQuestion());
                pst.setString(2, qs.getDescription());
                pst.setString(3, qs.getFormat());
                pst.setInt(4, qs.getPid().getPid());
                pst.setString(5, qs.getVisitType());
                pst.setShort(6, qs.getRequired());
                pst.setInt(7, QID);
                
                int rowCount = pst.executeUpdate();
                System.out.println(rowCount+" update-----Access");
            } 
            catch (SQLException e)
	    {		
                e.printStackTrace();
            }		
	}
                
	public void deleteQuestion(Connection con, int QID) throws SQLException
	{
            String SQL_QUERY = "delete from QUESTION where QID = "+QID;
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
        
        public ArrayList<Options> getOptionsByQID(Connection con, int QID)
        {
                ArrayList<Options> oplist = new ArrayList<Options>();
                
		try
		{
                    
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM OPTIONS where QID = "+QID);
		ResultSet rs = stmt.executeQuery();
                Question q = getQuestion(con, QID);
                
			while(rs.next())
			{
                            Options optObj = new Options();
				optObj.setQid(q);
                                optObj.setOptions(rs.getString("OPTIONS"));
                                optObj.setOpid(rs.getInt("OPID"));
                                System.out.println(rs.getString("OPTIONS")+" -- "+rs.getInt("OPID"));
                                oplist.add(optObj);
			}
                        System.out.println("get-----Access");
                        
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return oplist;	
        }
}