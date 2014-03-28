<!doctype	 html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="bootstrap-3.0.3/docs-assets/ico/favicon.png">

    <title>User Home Page</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap-3.0.3/dist/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
    body {
	background-repeat: repeat;
	font-weight: bolder;
	font-size: large;
	text-align: left;
	padding-top: 30px;
	padding-right: 30px;
	padding-bottom: 30px;
	padding-left: 30px;
	margin-left: 5px;
	background-color: #E7E7E7;
}
    </style>
</head>

<body>

<ul class="nav nav-pills nav-justified">
      <li class="active"><a href="Welcome.jsp">Welcome</a></li>
      <li><a href="AboutUs.jsp">About us</a></li>
      <li><a href="Register.jsp" onclick="return false;">Register</a></li>
      <li><a href="Login.jsp" onclick="return false;">Login</a></li>
      <li><a href="MostVisted.jsp">Most Visited</a></li>
      <li><a href="ContactUs.jsp">Contact</a></li>
    </ul>
<br>
Hello, <%= session.getAttribute( "name" ) %>
Hello, <%= session.getAttribute( "user_id" ) %>
<br>


<br>
<p> Sort/ Filter by </p>
 <br> <br>
 
 <div class="btn-group">
  <button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown">
   Parameters <span class="caret"></span>
  </button>
  
  <ul class="dropdown-menu">
    <li></li>
    <li></li>
  </ul>
  <ul class="dropdown-menu">
    <li><a href="#">Domain wise Analytics</a><a href="#">Resolution Time</a></li>
    <li><a href="#">Domain-Host Interaction</a></li>
  </ul>
</div>
 
 
 <div class="btn-group">
  <button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown">
   Fields <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" name= >
    <li><a href="#">Qps</a></li>
    <li><a href="#">Hits</a></li>
    <li><a href="#">Domain</a></li>
    <li><a href="#">TTL</a></li>
    <li><a href="#">Host</a></li>
  </ul>
</div>
 

<button type="submit" class="btn btn-default " style="font-size: large">Perform</button>
<script src="jquery-1.10.2.min.js"></script>
<script src="bootstrap-3.0.3/dist/js/bootstrap.min.js"></script>
<script src="bootstrap-3.0.3/docs-assets/js/holder.js"></script>
</body>
</html>