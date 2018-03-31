<%-- 
    Document   : visit
    Created on : 30 Mar, 2018, 5:36:21 PM
    Author     : Ishita
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        
    </head>
    <body>
 <div class="container">
     
     <div class="jumbotron" style="width: 60%; margin-top: 50px; margin-left: 20%">
         
     <form class="form-horizontal" action="ProgrammeClient">
        <div class="form-group">
            <label for="Name" class="control-label col-xs-2">Enter Name</label>
            <div class="col-xs-10">
                <input type="text" class="form-control" id="name" name = "name"  required>
            </div>
        </div>
        <div class="form-group">
            <label for="Description" class="control-label col-xs-2">Enter Description</label>
            <div class="col-xs-10">
                <select class="form-control" id="description" name="description">
                <option value="australia">Australia</option>
                <option value="canada">Canada</option>
                <option value="usa">USA</option>
                </select>
            </div>
        </div>       
         <div class="form-group">
             <label for="Date" class="control-label col-xs-2">Set Launch </label>
             <div class="col-xs-10">
                 <input class="form-control" type="date" id ="date" name = "date" data-date-inline-picker="true" />
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