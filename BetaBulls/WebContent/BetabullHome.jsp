<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>

<link rel="shortcut icon" href="resources/images/favicon.ico" type="resources/image/x-icon">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   
   <link rel="stylesheet" type="text/css" href="resources/css/custom.css">
   <link rel="script" type="text/javascript" href="resources/javascript/javascript.js">
   <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">



</head>

<body>


 
 
 <div class="nav-back">
 <div class="navbar-wrapper">
    <div class="container-fluid">
        <nav class="navbar nav-bottom">
            <div class="">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><!--div class="logo">
				<img src="images/betabulls.png" class="img-responsive"/>
				</div--></a>
                </div>
                
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                       <div class="col-md-6">
			<div class="logo">
				<img src="resources/images/betabulls.png" class="img-responsive"/>
			</div>
		    </div>
                 <div class="col-md-6">
			<ul class="social-network social-circle">
                        <li><a href="https://www.facebook.com/" class="icoFacebook" title="Facebook"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="https://twitter.com/" class="icoTwitter" title="Twitter"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="https://plus.google.com/collections/featured" class="icoGoogle" title="Google +"><i class="fa fa-google-plus"></i></a></li>
                        <li><a href="https://www.linkedin.com/" class="icoLinkedin" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
                    </ul>
		</div>           
                       
                        
                        
                        <div class="col-md-6">
                    <ul class="nav navbar-nav pull-right">
						
                        <li class=" dropdown"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Login As  <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="Index.jsp">Admin</a></li>
                                
								<li><a href="FepsLogin.jsp">Employee</a></li>
								
                            </ul>
                        </li>
                     </ul>
                     </div>
                </div>
            </div>
        </nav>
    </div>
</div>
</div>
<div class="form-group">
<div class="container" style="min-height:430px">
		<div class="row dash-up">
		
			<img src="resources/images/atf.jpg" class="img-responsive"/>
		</div>
	</div>
<div class="container" style="min-height:400px">
		<div class="card card-container">
           <h1 align="center" >BETABULLS</h1>
            <img id="profile-img" class="profile-img-card" src="resources/images/bull.png" />
			<h2 align="center">Login</h2>
            <p id="profile-name" class="profile-name-card"></p>
           
           
 <form class="form-signin" name="myForm" method="get" action="LoginServlet" >
 
                 <span id="reauth-email" class="reauth-email"></span>
                <input type="email" id="email" name="mailid" class="form-control" placeholder="Email Address" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{3,3}$" required >
                <input type="password" id="password" name="passWord" class="form-control" placeholder="Password" required>
                <div id="remember" class="checkbox">
                    <label for="remember-me">
                        <input type="checkbox" value="remember-me" id="remember123" name="remember" checked> Remember me
                    </label>
                </div>
                 <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" onclick="check(this.form)">Sign In</button></a>
            <a href="#" class="forgot-password">
                Forgot the password?
            </a>
			<a href="RegistrationForm.jsp" class="sign up" style="margin-left:73px";>
                Sign Up
            </a>
        </div>
    </div>
	</form>
		<div class="fdown">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12">
						&#169; 2014 BetaBulls *  Privacy Policy
					</div>
				</div>
			</div>
		</div>



</body>
</html>