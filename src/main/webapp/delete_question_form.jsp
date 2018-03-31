<%-- 
    Document   : delete_question_form
    Created on : 30 Mar, 2018, 4:23:33 PM
    Author     : ashima
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@include file="Connection.jsp" %>
<%
    int tid = Integer.parseInt(request.getParameter("tid"));
    String sql = "DELETE FROM `question_option` WHERE qid IN (SELECT QID FROM `question` WHERE TID ="+tid+")";
    PreparedStatement ps = con.prepareCall(sql);
    ps.executeUpdate();
    sql = "DELETE FROM `question` WHERE tid ="+tid;
    ps = con.prepareCall(sql);
    ps.executeUpdate();
    
    response.getWriter().println(tid);
    
%>