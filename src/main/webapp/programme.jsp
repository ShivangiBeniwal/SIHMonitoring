<%-- 
    Document   : visit
    Created on : 30 Mar, 2018, 5:36:21 PM
    Author     : Ishita
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header_admin.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
  <script type="text/javascript">
    var service = '/use_profile';
     var RestGet = function (id) {
         $.ajax({
             type: 'GET',
             url: service + "/" + id,
             dataType: 'json',
             async: false,
             success: function (result) {
                 $('#result').html(JSON.stringify(result));
 
             },
             error: function (jqXHR, textStatus, errorThrown) {
                 $('#response').html(JSON.stringify(jqXHR));
             }
         });
     };
     RestGet('my'); </script>
   <style>
    .but{
    
    float: left;
    color: #ffffff;
    background-color: #999999;
    padding: 14px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    }

  </style>
    </head>
    <body>
        <h1 style="color: white"><center>Create Program</center></h1>
 <div class="container">
     
     <div class="jumbotron" style="width: 60%; margin-top: 50px; margin-left: 20%; opacity: 1">
         
     <form class="form-horizontal" action="ProgrammeClient">
        <div class="form-group">
            <label for="Name" class="control-label col-xs-2" style="width: 15em;margin-left: -8em">Enter Name</label>
            <div class="col-xs-10" >
                <input type="text" class="form-control" id="name" name = "name" placeholder="Enter Text Here"  required>
            </div>
        </div>
        <div class="form-group">
            <label for="Description" class="control-label col-xs-2" style="width: 15em;margin-left: -8em" >Enter Description</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" id="name" name = "name"  required placeholder="Enter Text Here">
            </div>
        </div>       
         <div class="form-group">
             <label for="Date" class="control-label col-xs-2" style="width: 15em;margin-left: -8em">Set Launch </label>
             <div class="col-xs-10">
                 <input class="form-control" type="date" id ="date" name = "date" data-date-inline-picker="true" />
             </div>
         </div>
         <div class="form-group">
            <div class="col-xs-offset-2 col-xs-10">
                <button type="submit" class="btn btn-primary but">Submit</button>
            </div>
          </div>
         
          
    </form>
     </div>
   
</div>
 
       
    </body>
</html>