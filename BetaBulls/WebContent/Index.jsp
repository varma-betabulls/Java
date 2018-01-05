<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginPage</title>
<link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
   
   <link rel="stylesheet" type="text/css" href="resources/css/custom.css">
   <link rel="script" type="text/javascript" href="resources/javascript/javascript.js">
</head>

<body>

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
	<script>
var data=JSON.parse(localStorage.getItem("details"));
if((data=="")||(data==null))
{
document.getElementById("email").value="";
document.getElementById("password").value="";
}
else
{
document.getElementById("email").value=data[0];
document.getElementById("password").value=data[1];
}
var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z]{3,3})+$/;
function check(form)/*function to check userid & password*/
{
 var x = document.getElementById("remember123").checked;
 /*the following code checkes whether the entered userid and password are matching*/
  if(form.email.value == ""){
	alert("Please fill e-mail adress");
	$("#email").focus();
	return false;
	}
 else if (!filter.test(email.value)) {
    alert('Please provide a valid email address');
	$("#email").focus();
    return false;
	}
	else if(form.password.value==""){
	alert("Please Fill Password");
	return false;
	} 
	else{
	localStorage.clear();
	var details=[form.email.value,form.password.value]
		localStorage.setItem("details",JSON.stringify(details));

 if(!x)
{
localStorage.clear();
}
		
 }
 
}

</script>

</body>
</html>