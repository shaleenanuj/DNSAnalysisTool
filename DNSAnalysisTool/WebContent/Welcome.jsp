<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="bootstrap-3.0.3/docs-assets/ico/favicon.png">

    <title>Landing Page</title>

    <!-- Bootstrap core CSS -->
    

    
    <link href="LandingPageStyle.css" rel="stylesheet">
    <link href="MultitabPage.css" rel="stylesheet" type="text/css">
  </head>
<!-- NAVBAR
================================================== -->
  <body>
    <ul class="nav nav-pills nav-justified">
      <li class="active"><a href="Welcome.jsp">Welcome</a></li>
      <li><a href="AboutUs.jsp">About us</a></li>
      <li><a href="Register.jsp">Register</a></li>
      <li><a href="Login.jsp">Login</a></li>
      <li><a href="MostVisted.jsp">Most Visited</a></li>
      <li><a href="ContactUs.jsp">Contact</a></li>
    </ul>
    

    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner">
        <div class="item active">
          <img src="img1.jpg" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>First</h1>
             
            </div>
          </div>
        </div>
        <div class="item">
          <img src="img2.png" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Second</h1>
              
            </div>
          </div>
        </div>
        <div class="item">
          <img src="img3.jpg" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Third</h1>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
    </div><!-- /.carousel -->

      <footer>
        
        <p>&copy; 2014 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="jquery-1.10.2.min.js"></script>
    <script src="bootstrap-3.0.3/dist/js/bootstrap.min.js"></script>
    <script src="bootstrap-3.0.3/docs-assets/js/holder.js"></script>
  </body>
</html>
