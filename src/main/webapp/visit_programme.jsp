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
        
        <!--Bootstrap-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">  
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
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
        <h1 style="color: white"><center>Programmes of MoHFW</center></h1>
        <h3 style="color: white"><center>(Click on the programs to view their details)</center></h3>
        
    <center>
        <div class="districts_list">

                <%
              
                String description , deadline , name;
                int pid;
                PreparedStatement stmt = con.prepareStatement("SELECT * from PROGRAMME");
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
                    name = rs.getString("NAME");
                    //description = rs.getString("DESCRIPTION");
                    pid = rs.getInt("PID");
                    String url  = "viewTasks_Programme.jsp?"+"pid="+pid;
                            
                  %> 
                    
               
 
          <div class="districts_div">
              <a href="<% out.println(url) ; %>" style="font-size: 2em;float: left; margin-left: 1em; margin-top: 0.7em;"  />
           
           <%  out.println(name); %>
          </a>
  
        </div>
          
  <%
    }
%>    

<br> <br>
<form action="programme.jsp">
    <input type="submit" value="Add Programme" class="btn btn-primary">
</form> 
                </div>
                
    </body>
</center>
</html>