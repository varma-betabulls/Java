<%@page import="java.util.Iterator"%>
<%@page language="java" import="java.util.*"%>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="java.sql.*" %>
    <%@ page import="javax.servlet.http.HttpSession" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>Profile Information</title>
       <link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   
   <link rel="stylesheet" type="text/css" href="resources/css/custom.css">
   <link rel="script" type="text/javascript" href="resources/javascript/javascript.js">
   <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>

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
				<img src="images/betabulls.png" class="img-responsive"/>
				</div--></a>
                </div>
                
                <font color="white"><h5 align="right">Welcome <%=session.getAttribute("empname") %>,</h5></font>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="HomeServlet" class="">Dashboard</a></li>
                        <li class=" dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Employees <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class=" dropdown">
                                    <!--<a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">List Employees</a>-->
                                
                                <li><a href="AddEmployee.jsp">Add Employee</a></li>
								 <li><a href="ViewEmployees.jsp">List Of Employees </a></li>
								 
                            </ul>
							</li>
                            
                        <!--li><a href="#">Manage Employees</a></li-->
                        <li class=" dropdown">
						<a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Leaves <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                               <li><a href="AddLeaves.jsp">Add Leaves</a></li>
                                <li><a href="MangLvServlet">Manage Leaves</a></li>
								  <li><a href="ListLeavePositionServlet">List Leave Position</a></li>
								  <li><a href="UninformedLeaves.jsp">Uninformed Leave</a></li>
                            </ul>
                        </li>
                        <li class=" dropdown"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Time Sheet<span class="caret"></span></a>
                            <ul class="dropdown-menu">
								<li><a href="AddAttnd.jsp">Add Attendence</a></li>
                                 <li><a href="AddAttendence.jsp">Add Attendence Sheet</a></li>
                                <li><a href="ManageAttendence.jsp">Manage Attendence</a></li>
                                <li><a href="ListAttendenceServlet">List Attendence</a></li>
                            </ul>
                        </li>
                         <li class=" down"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Reports<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="ExtraLeavesServlet">Report on Leaves Taken</a></li>
                                
								<li><a href="AbsenteesServlet">Report On Absentees</a></li>
								<li><a href="Below9hrsServlet">Report On Below 9Hours</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
						
                        <li class=" dropdown"><a href="#" class="dropdown-toggle active" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Signed In As  <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="PasswordChange.jsp">Change Password</a></li>
                                <li><a href="Profile.jsp">My Profile</a></li>
								 
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
<div class="container" style="min-height:520px">
	<div class="row">
		<div class="col-md-3">
			<div class="profile-main">
				<div class="profile-img">
					<img src="resources/images/a.jpg" class="img-responsive center-block">
					<ul>
						
						<li><a href="ProfileServlet">Edit Profile</a></li>
					</ul>
				</div>
			</div>
		</div>

<form action="ProfileServlet" method="get">
		<div class="col-md-9">
			<div class="profile-main-content">
				<fieldset style="min-height: 220px;">
		<legend>Profile InFormation</legend>
				
				
				<%
				
				HttpSession sess=request.getSession();
				String user=(String)sess.getAttribute("name");
		
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
PreparedStatement stmt=con.prepareStatement("select firstname,lastname,mailid,mobile,dob,address,city,state from empregistration where mailid=?");
stmt.setString(1,user);
ResultSet rs=stmt.executeQuery();

  while(rs.next())
  {
	  String fname=rs.getString("firstname");
		String lname=rs.getString("lastname");
		String mailid=rs.getString("mailid");
		String mobile=rs.getString("mobile");
		String dob=rs.getString("dob");
		String address=rs.getString("address");
		String city=rs.getString("city");
		String state=rs.getString("state");
  %>
   				<div style="font-size:16px;padding:15px 0px">
					<div class="col-md-3">
						First Name <span class="pull-right">:</span>
					</div>
					<div class="col-md-9">
						<%=fname %>
					</div>
				</div>
				<div style="font-size:16px;padding:15px 0px">
					<div class="col-md-3">
						Last Name <span class="pull-right">:</span>
					</div>
					<div class="col-md-9">
						<%=lname%>
					</div>
				</div>
				<div style="font-size:16px;padding:15px 0px">
					<div class="col-md-3">
						Email Address <span class="pull-right">:</span>
					</div>
					<div class="col-md-9">
						<%=mailid%>
					</div>
				</div>
				<div style="font-size:16px;padding:15px 0px">
					<div class="col-md-3">
						Contact No <span class="pull-right">:</span>
					</div>
					<div class="col-md-9">
						<%=mobile%>
					</div>
				</div>
				<div style="font-size:16px;padding:15px 0px">
					<div class="col-md-3">
						Date Of Birth <span class="pull-right">:</span>
					</div>
					<div class="col-md-9">
						<%=dob%>
					</div>
				</div>
				<div style="font-size:16px;padding:15px 0px">
					<div class="col-md-3">
						Address <span class="pull-right">:</span>
					</div>
					<div class="col-md-9">
						<%=address%>
					</div>
				</div>
				<div style="font-size:16px;padding:15px 0px">
					<div class="col-md-3">
						City <span class="pull-right">:</span>
					</div>
					<div class="col-md-9">
						<%=city%>
					</div>
				</div>
				<div style="font-size:16px;padding:15px 0px">
					<div class="col-md-3">
						State <span class="pull-right">:</span>
					</div>
					<div class="col-md-9">
						<%=state%>
					</div>
				</div>
				<%
  } %>
  <div style="text-align:center;">
				
				<button type="submit" class="btn btn-info" ><span class="glyphicon glyphicon-saved"></span> EDIT</button>
				</div>
	 
  
  	
			</fieldset>
			</div>
			</div>
			</form>
			</div>
			</div>
			
			
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
