<%-- 
    Document   : show_question
    Created on : 30 Mar, 2018, 2:22:35 PM
    Author     : ashima
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@include file="Connection.jsp" %>
<%
int tid = Integer.parseInt(request.getParameter("tid"));
String sql = "SELECT * FROM `question` WHERE TID = "+tid+"";
Statement stm = con.createStatement();
ResultSet rs = stm.executeQuery(sql);
int qid;
String question=null, description=null, format=null;
boolean required;
String text = "";
while(rs.next()){
    qid = rs.getInt("qid");
    question = rs.getString("question");
    description = rs.getString("Description");
    format = rs.getString("format");
    required = rs.getBoolean("required");
    out.println("<div id=added_question>");
    if(required==true){
        out.println("<label><span class=req_class>*Required</span></label><br><br>");
    }
    out.println("<label><span class=quest>"+question+"</span></label>");
    out.println("<label for=inputType class=format_quest>Question Format : "+format+" </label>");
    out.println("<br>");
    out.println("<label for=inputType class=quest style=\"color: #999999\">"+description+"</label>");
    out.println("<div  id=question_option_add>");
    out.println("<br>");
    if(format.equalsIgnoreCase("Radio Button") || format.equalsIgnoreCase("Multiple Choice") || format.equalsIgnoreCase("Drop Down")){
        String sql1 = "select * from question_option where qid ="+qid;
        Statement stm1 = con.createStatement();
        ResultSet rs1 = stm1.executeQuery(sql1);

        out.println("<label class=quest>Options :-</label>");
        out.println("<br><br>");
        out.println("<ul>");
        while(rs1.next()){
            out.println("<li><label class=quest style=\"color: #666666\" >"+rs1.getString("ques_option")+"</label></li><br><br>");
        }
        out.println("</ul>");
    }
    
    out.println("</div>");
    out.println("</div>");
    
}


%>

