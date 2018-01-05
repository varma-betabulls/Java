<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page language="java" import="java.util.*"%>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="org.prasad.TimeSheet.ClockPojo" %>
    <% List<ClockPojo> cList = (ArrayList<ClockPojo>)request.getAttribute("clock");%>
<% ClockPojo ePojo = new ClockPojo(); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>

<link rel="shortcut icon" href="resources/images/favicon.ico" type="resources/image/x-icon">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   <script src="resources/javascript/jspdf.js"></script>
   <script src="javascript/jquery-2.1.3.js"></script>
   <script src="javascript/pdfFromHTML.js"></script>
   <link rel="stylesheet" type="text/css" href="resources/css/custom.css">
   <link rel="script" type="text/javascript" href="resources/javascript/javascript.js">
   <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<style>
.raa{align:right;}

</style>
<body>
<center>
<span class="raa">
<font color="#FF0000" size="3" ><b>


Current Time: <span id="txt"></span> </b>

<script>  
window.onload=function(){getTime();}  
function getTime(){  
var today=new Date();  
var y=today.getFullYear();
var mn=today.getMonth();
var d=today.getDate();
var h=today.getHours();  
var m=today.getMinutes();  
var s=today.getSeconds();  

// add a zero in front of numbers<10  
m=checkTime(m);  
s=checkTime(s);  

document.getElementById('txt').innerHTML=d+":"+mn+":"+y+":"+h+":"+m+":"+s;  
setTimeout(function(){getTime()},1000);  
}  
//setInterval("getTime()",1000);//another way  
function checkTime(i){  
if (i<10){  
  i="0" + i;  
 }  
return i;  
}  

</script>

  
</font>
</center>
</span></b>
<div class="main-header">
 <div class="container-fluid">
	<div class="row">
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
	</div>
 </div>
 </div>
 
 
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
				<img src="resources/images/betabulls.png" class="img-responsive"/>
				</div--></a>
                </div>
                <font color="white"><h5 align="right">Welcome <%=session.getAttribute("empname") %>,</h5></font>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="HomePage.jsp" class="">Dashboard</a></li>
                        <li class=" dropdown ">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Employees <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class=" dropdown">
                                    <!--<a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">List Employees</a>-->
                                
                                <li>
								<a href="AddEmployee.jsp">Add Employee</a></li>
							 <li><a href="ViewEmployees.jsp">List Of Employees </a></li>
								 
                            </ul>
							</li>
                            
                        <!--li><a href="#">Manage Employees</a></li-->
                        <li class=" dropdown">
						<a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Leaves <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                
                                <li><a href="ManageLeaves.jsp">Manage Leaves</a></li>
								  <li><a href="ListLeavePosition.jsp">List Leave Position</a></li>
								  <li><a href="ApplyLeave.jsp">Apply Leave</a></li>
                            </ul>
                        </li>
                        <li class=" dropdown"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Time Sheet<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                            
                                <li><a href="HomePage1.jsp">Feps(ClockIn/Out)</a></li>
                                
                                <li><a href="ViewTimeSheetServlet">View TimeSheet</a></li>
                            </ul>
                        </li>
                        <li class=" down"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Reports<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="ExtraLeaves.jsp">Extra Leaves Taken</a></li>
                                
								<li><a href="ReportonAbsentees.jsp">Report On Absentees</a></li>
								<li><a href="Below9hrsServlet">Report On Below 9Hours</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
						
                        <li class=" dropdown"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Signed In As  <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="PasswordChange.jsp">Change Password</a></li>
                                
								<li><a href="Profile.jsp">My profile</a></li>
								<li><a href="Index.jsp">Logout</a></li>
                            </ul>
                        </li>
                        <li class="profileicon-border"><img src="resources/images/a.jpg" class="img-responsive profileicon"></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
</div>

<div id="testdiv">

<form  method="get" action="ViewTimeSheetServlet">
<div class="container">
<div class="col-sm-12">
						      <div class="row">
						          <div class="form-group">
						             <label>Month and Year</label>
						             <input type="month" placeholder="Select Month and Year" rows="3" class="form-control" name="fdate">
						           </div>
						      </div>
						   </div>
						   
						   </div>
			<input type="submit" value="Submit" />
			<h4 align="right">USER NAME : <%=request.getAttribute("user") %></h4>
<center>
<h2>TIME SHEET</h2>
<table border="2" width="70%" height="30%" bgcolor="#00FF00">
  <th><font color='Red'>DATE</font></th>
  <th><font color='Red'>CLOCK IN</font></th>
  <th><font color='Red'>CLOCK OUT</font></th>
  <th><font color='Red'>Total</font></th>
  
  <% for(ClockPojo cPojo:cList) { %>
  
<tr>
<td><%out.println(cPojo.getDate()); %></td>
<td><%out.println(cPojo.getTimein());%></td>
<td><%out.println(cPojo.getTimeout()); %></td>
<td><%out.println(cPojo.getTotal()); %></td>
</tr>
<% } %>
</table>
</div>

<button formaction="PDFConvertServlet">PDF</button>
<a href="#" onClick="testdiv()">Download</a>

</center>

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