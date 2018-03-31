<%-- 
    Document   : visit
    Created on : 30 Mar, 2018, 5:36:21 PM
    Author     : Ishita
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Connection.jsp" %>
<%@include file="Header_admin.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
    </head>
    <body>
 <div class="container">
     
               <%
      if(request.getParameter("txt") == null){
//                out.println("<center><h5 style=\"color:red\">no text</h5></center>");
      }
      else{
                out.println("<center><h5 style=\"color:red\">"+request.getParameter("txt")+"</h5></center>");
      }
  %>
     
     <div class="jumbotron" style="width: 60%; margin-top: 50px; margin-left: 20%">
         <form class="form-horizontal" action="TaskClients" method="post">
        <div class="form-group">
            <label for="District" class="control-label col-xs-2">Enter district</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" id="districst" name = "district" placeholder="District" required>
            </div>
        </div>
        <div class="form-group">
            <label for="Programme" class="control-label col-xs-2">Enter Programme</label>
            <div class="col-xs-10">
                <select class="form-control" id="programme" name="programme">

                <%
                PreparedStatement stmt = con.prepareStatement("SELECT NAME , PID FROM  PROGRAMME");
		 
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
                %>
                
                     <option value="<%out.println(rs.getInt("PID")); %>"> 
                         <% out.println(rs.getString("NAME")); %>
                      </option>
                      
                 <%
                }
                
                
               rs.close();
                %>
		
                              
                
                </select>
            </div>
        </div>
         
           <div class="form-group">
            <label for="Officer" class="control-label col-xs-2">Enter Officer </label>
            <div class="col-xs-10">
                <select class="form-control" id="officer" name="officer">

                <%
                PreparedStatement stm = con.prepareStatement("SELECT NAME , OID FROM  OFFICER");
		 
                ResultSet rs1 = stm.executeQuery();
                
                while(rs1.next()){
                %>
                
                     <option value="<%out.println(rs1.getInt("OID"));  %>"> 
                         <% out.println(rs1.getString("NAME")); %>
                      </option>
                      
                 <%
                }
                
                
                
                %>
		
                              
                
                </select>
            </div>
        </div>
         
         
           <div class="form-group">
            <label for="address" class="control-label col-xs-2">Enter Address </label>
            <div class="col-xs-10">
                <select class="form-control" id="address" name="address">
                <%
                PreparedStatement s = con.prepareStatement("SELECT DISTRICT , AID FROM  ADDRESS");
		 
                ResultSet rs2 = s.executeQuery();
                
                while(rs2.next()){
                %>
                
                     <option value="<%out.println(rs2.getInt("AID"));  %>"> 
                         <% out.println(rs2.getString("DISTRICT")); %>
                      </option>
                      
                 <%
                }
                
                
                
                %>
                </select>
            </div>
        </div>
         
          <div class="form-group">
            <label for="visit type" class="control-label col-xs-2">Enter Visit Type </label>
            <div class="col-xs-10">
                <select class="form-control" id="type" name="type">
                <option value="door-to-door">Door-to-Door</option>
                <option value="hospital">Hospital</option>
                
                </select>
            </div>
        </div>
         
         
       <div class="form-group">
            <label for="description" class="control-label col-xs-2">Enter description</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" id="description" name = "description" placeholder="Description" required>
            </div>
        </div>
         <div class="form-group">
             <label for="Deadline" class="control-label col-xs-2">Set Deadline</label>
             <div class="col-xs-10">
                 <input class="form-control" type="date" id ="deadline" name = "deadline" data-date-inline-picker="true" />
             </div>
         </div>
                
                
          <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <%
         Date date = new Date();
          String mydate =  date.toString();
          %>
                <input type="hidden" value =" <% out.println(mydate); %> "  name ="setdate" class="form-control"></button>
            </div>
          </div>
          <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
          </div>
         
          
    </form>
     </div>
   
</div>
 
       
    </body>
</html>