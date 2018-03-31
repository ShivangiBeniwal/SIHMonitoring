<%-- 
    Document   : visiting_status
    Created on : 31 Mar, 2018, 1:12:13 PM
    Author     : ashim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header_admin.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .box{
                height: 1em;
                width: 1em;
                border: solid;
            }
            .actions{
                float: right;
                margin-right: 2em;
                background-color: whitesmoke;
                padding: 1em 1em 1em 1em;
            }
        </style>
    </head>
    <body>
        <br>
        <h1 style="color: white"><center>Status of the visits in the Geogrphies of India</center></h1>
        <div class="actions">
            <div class="box" style="background-color:  green"></div> &nbsp;&nbsp;&nbsp;&nbsp; - Completed
            <div class="box" style="background-color: yellow"></div> &nbsp;&nbsp;&nbsp;&nbsp; - Pending
            <div class="box" style="background-color:  red"></div> &nbsp;&nbsp;&nbsp;&nbsp; - Follow-up
        </div>
        <div style="margin-top: -4em;">
            <%@include file="google_map.jsp" %>
        </div>
    </body>
</html>
