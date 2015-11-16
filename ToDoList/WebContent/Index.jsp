<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Squares</title>
<link rel="stylesheet" type="text/css" href="index.css">

<%

String UserName=(String)session.getAttribute("UserName");


%>


</head>
<body>
<ul>
  <li class="leftList">Hi <%=UserName %></li>
 
</ul>
 <ul>
  <li><a href="logout">Logout</a></li>  
  <li><a href="#AboutUs">AboutUs</a></li>
  <li><a href="#Inbox">Inbox</a></li>
  <li><a href="#home">Home</a></li>  
  
</ul>


<a href="ShowAllList">
<div class="square">
    <div class="content">
    	<div class="table">
            <div class="table-cell">
        All
        </div>
        </div>
    </div>
</div>
</a>



<a href="Reports.html">
<div class="square">
    <div class="content">
    	<div class="table">
            <div class="table-cell">
        REPORTS
        </div>
        </div>
    </div>
</div>
</a>



<a href="New">
<div class="square">
    <div class="content">
    	<div class="table">
            <div class="table-cell">
        +
        </div>
        </div>
    </div>
</div>
</a>






</body>
</html>