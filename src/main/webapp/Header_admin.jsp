<%-- 
    Document   : Header_admin
    Created on : 31 Mar, 2018, 12:12:57 PM
    Author     : ashima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Header_admin.css">
        <title>JSP Page</title>
    </head>
    <body style="background-color: #993300">
        <ul>
            <li><a href="#home" class="li_left active">Visiting Status</a></li>
            <li><a href="#news" class="li_left">Programs</a></li>
            <li><a href="#contact" class="li_left">Officials Enrolled</a></li>
            <li><a href="#about" class="li_left">Statistics</a></li>
            <li><a href="logout.jsp" style="float: right" class="right_tab">Logout</a></li>
            <li><a href="#about" class="right_tab">Notifications</a></li>
            
            <span class="welcome">Welcome Admin</span>
        </ul>
        
    </body>
</html>
