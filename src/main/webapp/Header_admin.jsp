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
            <li><a href="#home" class="li_left a_home">Visiting Status</a></li>
            <li><a href="visit_programme.jsp" class="li_left a_home">Programs</a></li>
            <li><a href="View_District.jsp" class="li_left a_home">Districts</a></li>
            <li><a href="task.jsp" class="li_left a_home">Tasks for Districts</a></li>
            <li><a href="Graph.jsp" class="li_left a_home">Statistics</a></li>
            <li><a href="View_District.jsp" class="li_left a_home">District of India</a></li>
            <li><a href="logout.jsp" style="float: right" class="right_tab a_home">Logout</a></li>
            <li><a href="#about" class="right_tab a_home">Notifications</a></li>
            
            <span class="welcome">Welcome Admin</span>
        </ul>
        
    </body>
</html>
