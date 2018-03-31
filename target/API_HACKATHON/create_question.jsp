<%-- 
    Document   : create_question
    Created on : 30 Mar, 2018, 12:16:00 PM
    Author     : ashim
--%>



<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Connection.jsp" %>
<% 
 int tid = Integer.parseInt(request.getParameter("tid"));
 String question = request.getParameter("question");
 String visit_type = request.getParameter("visit_type");
 String quest_format = request.getParameter("quest_format");
 String description = request.getParameter("description");
 int no_of_option = Integer.parseInt(request.getParameter("no_of_option"));
 String required = request.getParameter("required");
 System.out.println(question+" "+quest_format+" "+description+" "+no_of_option+" "+required);
 
 //insertion in table
 try{
     
 String sql2 = "SELECT QID FROM `question` WHERE TID = "+tid+" AND QUESTION = '"+question+"' AND FORMAT = '"+quest_format+"' AND DESCRIPTION = '"+description+"' AND REQUIRED = "+required;
 Statement stm = con.createStatement();
 ResultSet rs = stm.executeQuery(sql2);
 int count = 0;
 while(rs.next()){
     count++;
 }
 
 if(count==0){
    String sql1 = "INSERT INTO `question`(`QUESTION`, `DESCRIPTION`, `FORMAT`, `TID`, `REQUIRED`, `visit_type`) VALUES ('"+question+"','"+description+"','"+quest_format+"',"+tid+","+required+",'"+visit_type+"')";
    System.out.println(sql1);
    PreparedStatement ps = con.prepareStatement(sql1); 
    ps.executeUpdate();

    for(int i=1; i<=no_of_option;i++){
        sql1 = "INSERT INTO `question_option` (`QID`, `QUES_OPTION`) VALUES ((SELECT QID FROM `question` WHERE TID = "+tid+" AND QUESTION = '"+question+"' AND FORMAT = '"+quest_format+"' AND DESCRIPTION = '"+description+"' AND REQUIRED = "+required+" ),'"+request.getParameter("option"+i)+"')";
        System.out.println(sql1);
        ps = con.prepareStatement(sql1);
        ps.executeUpdate();
        System.out.println(request.getParameter("option"+i));
    }
    response.getWriter().println("Question Created#"+tid);
 }
 else{
     response.getWriter().println("Already exist#"+tid);
 }
 
 }catch(Exception e){
     out.println(e);
 }
 
 
%>