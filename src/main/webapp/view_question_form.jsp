<%-- 
    Document   : view_question_form
    Created on : 30 Mar, 2018, 4:46:23 PM
    Author     : ashima
--%>

<%@page import="java.util.ArrayList"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Connection.jsp" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" type = "text/css" href = "css/view_question_form.css" />
        <title>JSP Page</title>
    </head>
    <body style="background-color: #cccccc">
    <center><div id="heading"><h1 style="color: #666666">QUESTIONNAIRE</h1></div></center>
        <%! int tid; %>
        <%
            tid = Integer.parseInt(request.getParameter("tid"));
            
            String sql = "select * from question where tid ="+tid;
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                int qid;
                String question=null, description=null, format=null;
                boolean required;
                qid = rs.getInt("qid");
                question = rs.getString("question");
                description = rs.getString("Description");
                format = rs.getString("format");
                required = rs.getBoolean("required"); 
//                out.println(qid);
//                out.println("<br>");
                out.println("<center><div class=quest_div>");
                out.println("<label class=label_quest>");
                out.println(question);
                out.println("</label>");
                out.println("<br>");
                out.println("<br>");
                out.println("<span class=desc>");
                out.println(description);
                out.println("</span>");
                out.println("<br><br>");
                
//                out.println(format);
//                out.println("<br>");
                if(required==true){
                    out.println("<span style=\"color:red; float:right; margin-top:-4.5em;\">*Required</span>");
                }
                 
                ArrayList<String> options = new ArrayList<String>();
                String sql1 = "select * from question_option where qid ="+qid;
                Statement stm1 = con.createStatement();
                ResultSet rs1 = stm1.executeQuery(sql1);
                
                while(rs1.next()){
                    options.add(rs1.getString("ques_option"));
//                    out.println(rs1.getString("ques_option")+"<br>");
                }
                
                //input field
                if(format.equalsIgnoreCase("text")){ 
                    out.println("<input type=\"text\" name=\"qid_text\" id=\"qid_text\" />");
                }
                else if(format.equalsIgnoreCase("Multiple Choice")){
                    for(String str : options){
                        out.println("<input type=checkbox value=\""+str+"\" name=\""+qid+"_checkbox\" id=\""+qid+"_checkbox\" class=check>");
                        out.println("<label class=radio_label>");
                        out.println(str);
                        out.println("</label>");
                        
                        out.println("<br><br>");
//                        out.println("<label><input type=checkbox value=\""+str+"\" name=\""+qid+"_checkbox\" id=\""+qid+"_checkbox\" class=check> \""+str+"\"</label><br>");
                    }
                }
                else if(format.equalsIgnoreCase("Drop Down")){
                    out.println("<select name="+qid+"_drop id="+qid+"_drop>");
                    for(String str : options){
                        out.println("<option value="+str+">"+str+"</option>");
                    }
                    out.println("</select>");
                }
                else if(format.equalsIgnoreCase("Radio Button")){
                    for(String str : options){
                        
                        out.println("<input class=radio_but type=radio name="+qid+"_radio value="+str+" >");
                        out.println("<label class=radio_label>");
                        out.println(str);
                        out.println("</label>");
                        
                        out.println("<br><br>");
                    }
                }
                else if(format.equalsIgnoreCase("Date")){
                    out.println("<input type=date name="+qid+"_date id="+qid+"_date >");
                }
                
                stm1.close();
                rs1.close();
                out.println("</div></center>");
            }
        %>
        
    <br>
    </body>
</html>
