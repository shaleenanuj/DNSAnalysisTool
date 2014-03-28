<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="bootstrap-3.0.3/docs-assets/ico/favicon.png">
    <link href="MultitabPage.css" rel="stylesheet" type="text/css">
    <title>Contact</title>

    <!-- Bootstrap core CSS -->
</head>
<!-- NAVBAR
================================================== -->
  <body>
  <% if(session.getAttribute("user_id")==null)
	  
	  response.sendRedirect("ContactUs.jsp");
	  
	  
	  %>
    <ul class="nav nav-pills nav-justified">
      <li><a href="Welcome_login.jsp">Welcome</a></li>
      <li><a href="AboutUs_login.jsp">About us</a></li>
      <li ><a href="NewUserHome.jsp">Home</a></li>
      <li><a href="MostVisted_login.jsp">Most Visited</a></li>
      <li class="active"><a href="ContactUs_login.jsp">Contact</a></li>
    </ul>
    
      <footer>
         <form action="Logout" method="post"> 
  <button type="submit" class="btn btn-default">Logout</button>
  </form>
        <p>&copy; 2014 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="jquery-1.10.2.min.js"></script>
    <script src="bootstrap-3.0.3/dist/js/bootstrap.min.js"></script>
    <script src="bootstrap-3.0.3/docs-assets/js/holder.js"></script>
  </body>
</html>
