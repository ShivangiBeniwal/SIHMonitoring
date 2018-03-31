<%-- 
    Document   : visit
    Created on : 30 Mar, 2018, 5:36:21 PM
    Author     : Ishita
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Connection.jsp" %>
        <%@include file="Header_admin.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>List</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js" type="text/javascript" async></script>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <style>

li{
background-color:cyan;
}
</style>
    </head>
    <body>
 

                <%
                String   dis   = request.getParameter("district");
                String description  , deadline ;
                int OID;
                
                PreparedStatement stmt = con.prepareStatement(" Select * FROM TASK WHERE AID IN (select AID FROM ADDRESS WHERE DISTRICT = '"+dis+"') ");
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
                    description = rs.getString("DESCRIPTION");
                    deadline = rs.getString("DEADLINE");
                  
                    

                    
                  
  
                  out.println(description);
  
        
          
                  
                  
                    
                }
                
		 
              %> 
                
                
 
       
    </body>
</html>