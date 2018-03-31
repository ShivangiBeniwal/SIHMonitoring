<%-- 
    Document   : Graph
    Created on : Mar 31, 2018, 9:42:12 AM
    Author     : shivangi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<%@include file="Header_admin.jsp" %>
 
<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();



               
	        String connectionURL = "jdbc:mysql://localhost:3307/FINAL_DB";
		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(connectionURL, "root", "system");
               
			
		
             
PreparedStatement stmt = connection.prepareStatement("  SELECT distinct(DISTRICT) , AID FROM ADDRESS WHERE STATE = 'DELHI' ");

ResultSet rs =  stmt.executeQuery(); 
while(rs.next()){
map = new HashMap<Object,Object>(); 
map.put("label", rs.getString("DISTRICT"));
String AID = rs.getString("AID");
int count = 0;
PreparedStatement st = connection.prepareStatement("  SELECT TID from TASK where STATUS_ID = 6 AND AID = '"+AID+"'");

ResultSet rs2 = st.executeQuery(); 
while(rs2.next()){
    count++;
  }

 map.put("y", count); list.add(map);

}
 

 



 String dataPoints = gsonObj.toJson(list);
%>



<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2", // "light1", "dark1", "dark2"
	exportEnabled: true,
	animationEnabled: true,
	title: {
		text: "Percentage of tasks completed in a State"
	},
	data: [{
		type: "pie",
		toolTipContent: "<b>{label}</b>: {y}%",
		indexLabelFontSize: 16,
		indexLabel: "{label} - {y}%",
		dataPoints: <%out.print(dataPoints);%>
	}]
});
chart.render();
 
}
</script>
</head>
<body>
<div id="chartContainer" style="height: 650px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>      