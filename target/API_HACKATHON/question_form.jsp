<%-- 
    Document   : question_form
    Created on : 30 Mar, 2018, 10:03:24 AM
    Author     : ashima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header_admin.jsp" %>
<br><br>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/question_form.js"></script>
        <link rel = "stylesheet" type = "text/css" href = "css/question_form.css" />
       
        <title>Question Form</title>
    
        
    </head>
    <%! int tid; %>
    <%
        tid = Integer.parseInt(request.getParameter("tid"));
        System.out.println(tid);
    %>
    <body onload="showQuestion(<%= tid %>)" style="background-color: #cccccc">
        <a href="view_question_form.jsp?tid=<%=tid%>"><input type="button" name="preview" id="preview" value="PREVIEW" class="prev" style="float: right" /></a>
        <select class="visit_type" id="visit_type">
        <option value="Door to door visit">Door to door visit</option>
        <option value="District visit">District visit</option>
    </select>
    <center><div id="heading"><h1>QUESTIONNAIRE</h1></div></center>
    
       <div>
        
            <form>
                <center>
                    <div id="add_ques">
                    
                        </div>
                    <div class="create_quest_div">
                
                 <label for="Question">Question : </label>
                 <input type="text" name="question" id="question"  Placeholder="Question">
                 
                
                 <label for="inputType" style="margin-left: 4em;">Question Format : </label>
                 <select name="question_format" id="question_format" onchange="quest_opt()">
                        <option value="Text">Text</option>
                        <option value="Multiple Choice">Multiple Choice</option>
                        <option value="Drop Down">Drop Down</option>
                        <option value="Radio Button">Radio Button</option>
                        <option value="Date">Date</option>
                 </select>
                 <br>
                
                 <br>
                    <textarea  name="question_description" id="question_description" placeholder="Enter Description" class="desc"></textarea>
                    <br>
                    <br>
                <div  id="question_option">
                    <br>
                    <label style="float: left;" >No. of options</label><br><br>
                    <input  type="text" name="no_of_option" id="no_of_option" placeholder="no_of_option" value="1" onkeyup="change_opt(this.value)" class="no_of_option" />
                    <br><br><br>
                    <label style="float: left;">Options :-</label>
                    <br>
                     <div  id="option">
                         <input placeholder="1)"  type="text" name="option1" id="option1" class="opt"/>
                        </div>
                </div>
                    <br><br>
                
                <span><input type="button"  name="create" value="create" id="create" onclick="create_question(<%= tid %>)"/></span>
                <span ><input type="button" style="margin-left: 1em;"  name="cancel" value="cancel" id="cancel" onclick="cancel_question()"/></span>
                <div>
                    <label style="float: right; margin-top: 1em; margin-right: -3em;">Required</label>
                    <label class="switch">
                        <input  type="checkbox" id="required" name="required">
                        <span class="slider round"></span>
                    </label> 
                </div>
                
                </div>
                </center>
                <br><br>
                <center>
                    <div style="margin-left: 30em;">
                    <input class="form_but" type="button" value="SAVE" name="save" id="save" onclick="save()"/>
                    <input class="form_but" type="button" value="DELETE" name="delete" id="delete" onclick="form_delete(<%= tid %>)"/>
                    </div>
                </center>
            </form>
        
    </div>
    </body>
</html>
