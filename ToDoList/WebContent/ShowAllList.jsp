<%@ page import="java.io.*,java.util.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Products</title>

<!-- Bootstrap -->
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
crossorigin="anonymous">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

</head>

<body style=background-color:grey>

<nav class="navbar navbar-inverse navbar-floating-top"
style="background-color: #141452">
<div class="container">
<div class="navbar-header">
<button type="button" class="navbar-toggle collapsed"
data-toggle="collapse" data-target="#navbar" aria-expanded="false"
aria-controls="navbar">
<span class="sr-only">Toggle navigation</span> <span
class="icon-bar"></span> <span class="icon-bar"></span> <span
class="icon-bar"></span>
</button>
</div>





<div class="container">
<nav class="navbar navbar-default">
<div class="container">
<div class="container">
<div class="navbar-header">
<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
<span class="sr-only">Toggle navigation</span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
</button>
<a class="navbar-brand" href="#"></a>
<%  
String id=(String) session.getValue("id");
String price=(String) session.getValue("Price");
String UserName=(String) session.getAttribute("UserName");
session.setAttribute("UserName", UserName);
session.setAttribute("id", id);
session.setAttribute("Price", price);
String cost=(String) session.getValue("cost");
 

%>
 <script>
            showMenu = function() {
                var div = document.getElementById('box1');
                div.style.display = 'block';
            }
            hideMenu = function() {
                var div = document.getElementById('box1');
                div.style.display = 'none';
            }
        </script>

<form action="logout" align="right">
<table>

<tr>
   
  
   <td colspan=6 valign="bottom" align="right">
                <div class="btn btn-primary" class="username" onmouseover="showMenu();" onmouseout="hideMenu();">"<%=UserName%>" , Click here to Logout
                    <span id="box1">
                        <a href="logout">Logout</a>
                    </span>
                </div>
            </td>
    
    
</table>

</form>

</div>
</div>
</div>
</nav>
<br>
<div class="panel panel-default">

<div class="panel-body">
<table class="table table-striped">
<thead>
<tr>
<th>ID</th>
<th>Description</th>
<th>DueDate</th>
<th>CompleteDate</th>
<th>SID</th>
<th>PRIORITY</th>

</tr>
</thead>
<tbody>

${tableinfo}

</tbody>

</table>


</body>
</html>