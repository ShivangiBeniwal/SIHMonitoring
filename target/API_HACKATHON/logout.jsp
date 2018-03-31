<%-- 
    Document   : logout
    Created on : 31 Mar, 2018, 1:51:58 PM
    Author     : ashim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session.invalidate();
    response.sendRedirect("homePage.jsp");
%>