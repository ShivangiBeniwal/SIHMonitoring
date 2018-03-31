<%-- 
    Document   : get_long_lat
    Created on : 30 Mar, 2018, 10:39:55 PM
    Author     : ashim
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Connection.jsp" %>
<%@page import="java.sql.*,org.json.*;" %>

        <%
     
    Statement stmt = null;
    ResultSet result = null;
    
    try{
        
        String query;
        
        stmt = con.createStatement();
        
        query = "SELECT * FROM visit";
        result = stmt.executeQuery(query);
        
        if(!result.next()){
            out.print("0");
        }else{
            JSONArray array=new JSONArray();
            do{
                JSONObject obj = new JSONObject();
                obj.put("lat",result.getString("lat"));
                obj.put("long",result.getString("longitude"));
                obj.put("action",result.getString("action_id"));
                array.put(obj.toString());
            }while(result.next());
            out.print(array);
        }
        
    }catch(SQLException e){
        out.print("Exception: "+e);
    }
    finally{
        if(stmt != null){
            try{
                stmt.close();
            }catch(SQLException e){}
        }
        if(con != null){
            try{
                con.close();
            }catch(SQLException e){}
        }
    }
        
        
        
        %>
    