<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="bootstrap-3.0.3/docs-assets/ico/favicon.png">

    <title>Sign in</title>

    <!-- Bootstrap core CSS -->
   <link href="bootstrap-3.0.3/dist/css/bootstrap.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="LoginStyle.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">
	 <center><font size="3" color="red">Already Login !!!</font></center>
      <form class="form-signin" role="form" method="post" action="ValidateUser">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" placeholder="Email address" name="user_id"  required autofocus>
        <input type="password" class="form-control" placeholder="Password" name="pwd" required>
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>