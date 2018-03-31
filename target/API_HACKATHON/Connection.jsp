<%-- 
    Document   : Connection
    Created on : 30 Mar, 2018, 12:31:45 PM
    Author     : ashima
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! Connection con; %>
        <%
        
        try{
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3307/FINAL_DB","root","system");
        }    
        catch(Exception e){
            out.println("error..... <br>"+e); 
        }
        
%>
    