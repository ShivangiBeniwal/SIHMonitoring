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
        <title>JSP Page</title>
        <style>
            .districts_list{
                width: 50em;
                height: 25em;
                margin-top: 2em;
            }
            
            .districts_div{
                width: 50em;
                height: 5em;
                background-color: #cccccc;
                margin-top: 0.5em;
            }
            
        </style>
        
    </head>
    <body>
        <h1 style="color: white"><center>Districts of India</center></h1>
        <h3 style="color: white"><center>(Click on the districts to view their programs)</center></h3>
        
    <center>
        <div class="districts_list">

                <%
              
                String district , deadline , name;
                
                PreparedStatement stmt = con.prepareStatement("SELECT DISTINCT(DISTRICT) FROM ADDRESS ");
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
                    district = rs.getString("DISTRICT");
                    String url  = "viewTasks_District.jsp?"+"district="+district;
                            
                  %> 
                    
               
 
          <div class="districts_div">
              <a href="<% out.println(url) ; %>" style="font-size: 2em;float: left; margin-left: 1em; margin-top: 0.7em;" class="list-group-item list-group-item-action" />
           
           <%  out.println(district); %>
          </a>
  
        </div>
          
  <%
    }
%>             
                </div>
                
    </body>
</center>
</html>