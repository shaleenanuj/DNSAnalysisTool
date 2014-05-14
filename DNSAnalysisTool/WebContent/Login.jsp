
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
<br><br><br><br><br><br><br><br>Click <a href="Admin_Login.jsp">here</a>for admin login
  </body>
</html>