<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="bootstrap-3.0.3/docs-assets/ico/favicon.png">

    <title>Register</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap-3.0.3/dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="RegisterStyle.css" rel="stylesheet">
	
  </head>

  <body>
  <script>
	    function validateForm()
		{
		var x=document.forms["reg_form"]["user_name"].value;
		var y=document.forms["reg_form"]["email_id"].value;
		var z=document.forms["reg_form"]["pswd"].value;
		var w=document.forms["reg_form"]["re_pswd"].value;
			if (x==null || x=="")
	    	{
  			alert("First name must be filled out");
  			return false;
  			}
		
			if(z==null || z=="")
	    	{
  			alert("Password cannot be null");
  			return false;
  			}
  			
  			if(z!=y)
  			{
  			alert("Passwords do not match");
  			return false;
  			}
		
		var atpos=y.indexOf("@");
		var dotpos=y.lastIndexOf(".");
			if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
		    {
  			alert("Not a valid e-mail address");
  			return false;
  			}			
				
		}
	   </script>
	<ul class="nav nav-pills nav-justified">
      <li><a href="#">Welcome</a></li>
      <li><a href="AboutUs.jsp">About us</a></li>
      <li class="Register.jsp"><a href="#">Register</a></li>
      <li><a href="Login.jsp">Login</a></li>
      <li><a href="MostVisted.jsp">Most Visited</a></li>
      <li><a href="ContactUs.jsp">Contact</a></li>
    </ul>
    
    <div class="container">

      <form class="form-signin" role="form" method="post" action="SaveUser">
        <h2 class="form-signin-heading">Sign up</h2>
        <input type="text" class="form-control" placeholder="User-id" name="user_id" required autofocus> <br>
        <input type="text" class="form-control" placeholder="User name" name="user_name" required > <br>
        <input type="password" class="form-control" placeholder="Password" name="pswd" required> <br>
         <input type="email" class="form-control" placeholder="Email id" name="email" required> <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
      </form>

    </div> <!-- /container -->

	 <script src="jquery-1.10.2.min.js"></script>
    <script src="bootstrap-3.0.3/dist/js/bootstrap.min.js"></script>
    <script src="bootstrap-3.0.3/docs-assets/js/holder.js"></script>
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>