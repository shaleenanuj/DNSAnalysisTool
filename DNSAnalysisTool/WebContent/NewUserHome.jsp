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
<script type="text/javascript">
		
    function hide1(){
        alert("123");
         document.getElementById("t4").style.visibility = 'hidden';  
         document.getElementById("t5").style.visibility = 'hidden'; 
         document.getElementById("t1").style.visibility = 'hidden';  
         document.getElementById("t2").style.visibility = 'hidden'; 
         document.getElementById("t3").style.visibility = 'hidden';
         document.getElementById("t7").style.display='block';                                                  
         document.getElementById("t6").style.display='block';
    }
    function test() {
				var x = new Date();
				
				var y = new Date(document.getElementById("di1").value);
				var z = new Date(document.getElementById("di2").value);
				
			
				if (x < y || x < z) {
					
					alert("enter a date from past");
					return false;
				} else if (y > z) {
					
					alert("provide proper range");
					return false;
				}else
					{
					return true;				
					}
				return false;
			
			}
			
			function check(){
				
				if(document.abc.basis1[0].checked)
					{ document.getElementById("t1").style.visibility = 'visible';
                                  document.getElementById("t2").style.visibility = 'visible';
                                  document.getElementById("t3").style.visibility = 'visible';
                                   document.getElementById("t4").style.visibility = 'hidden';  
                                            document.getElementById("t5").style.visibility = 'hidden'; 
                                             
                                        }			
                                        
                              if(document.abc.basis1[1].checked)
                              {                               
                                            document.getElementById("t1").style.visibility = 'hidden';  
                                            document.getElementById("t2").style.visibility = 'hidden'; 
                                            document.getElementById("t3").style.visibility = 'hidden';
                                            document.getElementById("t4").style.visibility = 'visible';
                                            document.getElementById("t5").style.visibility = 'visible';
                                      
                               
                               }
                               
                                if(document.abc.basis3[0].checked)
                                            {                                         
                                                document.getElementById("t6").style.display='none'
                                                  document.getElementById("t7").style.display='block'
                                                
                                            }
                                            
                                      if(document.abc.basis3[1].checked)
                                      {
                                            document.getElementById("t6").style.display='block'
                                              document.getElementById("t7").style.display='none'
                                      } 
                               
                              }
			
		</script>
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
}About
    </style>
</head>

<body>
<% if(session.getAttribute("user_id")==null)
response.sendRedirect("Login.jsp");
	  
	  
	  %>
<ul class="nav nav-pills nav-justified">
      <li><a href="Welcome_login.jsp">Welcome</a></li>
      <li><a href="AboutUs_login.jsp">About us</a></li>
      <li class="active"><a href="#">Home</a></li>
      <li><a href="MostVisted_login.jsp">Most Visited</a></li>
      <li><a href="ContactUs_login.jsp">Contact</a></li>
    </ul>
<br>
Hello, <%= session.getAttribute( "name" ) %>

 
<br>


<br>
<p> Sort/ Filter by </p> <br>
<form action="PerformAnalytics" method="get" onsubmit="return test();" name="abc" onload="hide1()">
     
 
 <input type="radio"  value="ServerInteraction" id="basis1" name="basis1" onClick="check()" >Server Interaction  
 <input type="radio"  value="Domain-HostInteraction" id="basis1" name="basis1" onClick="check()" >Domain-Host Interaction
 <br>
<br>
<div id="t1"  ><input type="radio" name="basis2" id="basis2" value="Type">Type</div> 
<div id="t2" > <input type="radio" name="basis2" id="basis2" value="Query" >Query Hits</div> 
<div id="t3" > <input type="radio" name="basis2" id="basis2" value="Ips" >Source</div>
 <br>
 <br>
 <div id="t4" > <input type="radio" name="basis3" id="basis3" value="Dip" onclick="check()" >For a particular domain</div>
 <div id="t5" ><input type="radio" name="basis3" id="basis3" value="Ipd" onclick="check()" >For a particular host</div>
  <br><br>
  <div id="t6" >Ip Address<input type="text" name="ipaddress" id="ipaddress" ></div>
  <div id="t7" >Domain<input type="text" name="domain" id="domain" ></div>
  Date <input type="date" name="date1" id="di1" required>   Start Time <input
			type="time" name="time1" id="ti1" required> <br><br> <br>End Date <input
			type="date" name="date2" id="di2 " required> End Time <input
			type="time" name="time2" id="ti2" required>
 
<button type="submit" class="btn btn-default " style="font-size: large" onClick="test()">Perform</button>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
</form>

        <div class="btn-group">
  
  <form action="Logout" method="post"> 
  <button type="submit" class="btn btn-default">Logout</button>
        <p>&copy; 2014 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
        
  </form>
</div>
    

 
 
<script src="jquery-1.10.2.min.js"></script>
<script src="bootstrap-3.0.3/dist/js/bootstrap.min.js"></script>
<script src="bootstrap-3.0.3/docs-assets/js/holder.js"></script>


</body>

</html>