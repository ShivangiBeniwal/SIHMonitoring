<%-- 
    Document   : homePage
    Created on : 31 Mar, 2018, 8:34:09 AM
    Author     : ashima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/homePage.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
        <style>
            .loginbox{
                width: 320px;
                height: 360px;
                background-color: #999999;
                color: #000000;
                top: 60%;
                left: 15%;
                padding: 60px 30px;
                position: absolute;
                transform: translate(-50%,  -50%);
                box-sizing: border-box;
                border-radius: 3%;
            }
            h1{
                color: #fff;
                margin: 0;
                padding: 0 0 0px;
                text-align: center;
                font-size: 22px;
                font-weight: bold;
            }

            .loginbox p {
                margin: 0;
                padding: 0;
                font-weight: bold;
                font-size: 13px;
            }

            .loginbox input{
                width: 100%;
                margin-bottom: 20px;
            }

            .loginbox input[type="text"], input[type="password"]{
                border: none;
                border-bottom: 1px solid #bdc3c7;
                background: transparent;
                outline: none;
                height: 30px;
                font-size: 16px;
                opacity: 1;
                color: #ccc;
            }


            .loginbox input[type="submit"]{
                border: none;
                outline: none;
                height: 40px;
                background: #2ecc71;
                color: #fff;
                font-size: 14px;
                font-weight: bold;
                border-radius: 20px;
                font-family: 'Open Sans', sans-serif;
            }

            .loginbox input[type="submit"]:hover {
                cursor: pointer;
                background: #27ae60;
                color: #fff;

            }

            .loginbox a {
                font-size: 14px;
                text-decoration: none;
                color: #fff;
                opacity: 0.8;
            }

            .loginbox a:hover {
                color: #fff;
                opacity: 1;
            }

            #text-account {
                font-size: 14px;
                color: #fff;
                opacity: 0.4;
            }

            #create-account:hover {
                text-decoration: underline;
                font-weight: bold;
            }
            
        </style>
    </head>
    <body style="background-color:  #993300">
    
          <%
      if(request.getParameter("txt") == null){
//                out.println("<center><h5 style=\"color:red\">no text</h5></center>");
      }
      else{
                out.println("<center><h5 style=\"color:red\">"+request.getParameter("txt")+"</h5></center>");
      }
  %>
        
    <div class="loginbox">
        <h1>Sign in</h1><br>
        <form action="Login_Officer" method="post">
            <input type="text" name="emailId" placeholder="Username"><br>
            <input type="password" name="pass" placeholder="Password">
            <input type="submit" value="LOGIN">
        </form>
        <a href="#">Forgot Password?</a><br>
        <span id="text-account">Don't have an account?</span><a id="create-account" href="#"> Create here.</a>
    </div>
        
    <div class="container">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="item active">
          <img class="im" style="height: 30em;" src="image/img1.jpeg" alt="Los Angeles" >
        <div class="carousel-caption">
        </div>
      </div>

      <div class="item">
          <img style="height:30em;" class="im" src="image/img2.jpg" alt="Chicago">
        <div class="carousel-caption">
        </div>
      </div>
    
      <div class="item">
          <img style="height:30em;" class="im" src="image/img3.jpg" alt="New York">
        <div class="carousel-caption">
        </div>
      </div>
      <div class="item">
          <img style="height:30em;" class="im" src="image/img4.jpg" alt="New York" >
        <div class="carousel-caption">
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
        <script  src="js/homePage.js"></script>
          
        <footer id="footer-sih">
            hello
        </footer>
        
    </body>
</html>
