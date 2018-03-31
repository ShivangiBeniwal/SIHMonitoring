<%-- 
    Document   : google_map
    Created on : 30 Mar, 2018, 11:08:38 PM
    Author     : ashim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/google_map.js"></script>
        
        <style>
            #map{
                height: 30em;
                width: 70%;
                border: solid black;
                margin-top: 8em;
            }
        </style>
    </head>
    <body >
        <div id="data"></div>
    <center><div id="map"></div></center>
        <script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDFb45IKUllxuRqXv_qqLWMM63v6EXK6oQ&callback=getData">
        </script>
    </body>
</html>
