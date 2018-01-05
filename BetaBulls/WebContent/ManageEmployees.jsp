<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Iterator"%>
<%@page language="java" import="java.util.*"%>

<%@page import="java.sql.PreparedStatement" %>
<%@page import="org.prasad.AddEmployee.EmployeePojo" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="java.sql.*" %>
    <% List<EmployeePojo> eList = (ArrayList<EmployeePojo>)request.getAttribute("empList");%>
<% EmployeePojo ePojo = new EmployeePojo(); %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Manage Employee</title>
<link rel="shortcut icon" href="resources/images/favicon.ico" type="resources/image/x-icon">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   
   <link rel="stylesheet" type="text/css" href="resources/css/custom.css">
   <link rel="script" type="text/javascript" href="resources/javascript/javascript.js">
   <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<link href="style.css" rel="stylesheet" type="text/css">

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
                        <li><a href="HomeServlet" class="">Dashboard</a></li>
                        <li class=" dropdown active">
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
                                <!--li><a href="#">Bulk Upload</a></li-->
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
 
 
 <div class="container-fluid">
	<div class="row">
		<div class="form manageemployee " style="margin: 0 auto 25px; margin-top:35px;">
		<fieldset style="min-height: 490px;">
		<legend>Manage Employees</legend>
<form class="form-horizontal" method="get" name="MyForm" role="form" action="UpdateEmpServlet">
<%
for(EmployeePojo emp:eList)  {
%>
  <div class="form-group">
    <label class="control-label col-sm-3" for="employeeid">Employee Id <span style=color:red>*</span></label>
    <div class="col-sm-6">
	
      <input type="text" class="form-control"  value="<%out.println(emp.getEid());%>"
      name="eid" id="eid" placeholder="Enter Employee Id"  minlength="4"  maxlength="6" readonly="readonly" required >
    
  </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-3" for="pwd">Employee Name <span style=color:red>*</span></label>
    <div class="col-sm-6"> 
    
      <input type="text" class="form-control" value="<%out.println(emp.getEname());%>" name="ename" id="ename" placeholder="Enter Employee Name" required>
    
	 </div>
	 </div>
  <div class="form-group">
    <label class="control-label col-sm-3" for="pwd">Father Name <span style=color:red>*</span></label>
    <div class="col-sm-6"> 
    
      <input type="text" class="form-control" value="<%out.println(emp.getFathername());%>" name="fathername" id="fname" placeholder="Enter Father Name" required>
    
  </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-3" for="pwd">Address <span style=color:red>*</span></label>
    <div class="col-sm-6"> 
   
      <input type="text" class="form-control" value="<%out.println(emp.getEaddress());%>" name="eaddress" id="adress" placeholder="Enter Address" required></textarea>
    </div>
    </div>
 
  <div class="form-group">
    <label class="control-label col-sm-3" for="pwd">PINCODE <span style=color:red>*</span></label>
    <div class="col-sm-6"> 
   
      <input type="text" class="form-control" value="<%out.println(emp.getEpin());%>" name="epin" id="pincode" placeholder="Enter PinCode" pattern="[0-9]{6}" maxlength="6"required>
    </div>
    </div>
  
  <div class="form-group">
    <label class="control-label col-sm-3" for="pwd">Designation <span style=color:red>*</span></label>
    <div class="col-sm-6">
    
      <input type="text" class="form-control" value="<%out.println(emp.getEdesg()); %>" name="edesg" id="edesg" placeholder="Enter Designation" required>
    </div>
    </div>
  
  <div class="form-group">
    <label class="control-label col-sm-3" for="pwd">Date of Joining <span style=color:red>*</span></label>
    <div class="col-sm-6">
    
      <input type="text" class="form-control" value="<%out.println(emp.getEdoj()); %>" name="edoj" id="doj" placeholder="Date Of Joining" required>
    </div>
  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-3" for="pwd">Phone Number <span style=color:red>*</span></label>
    <div class="col-sm-6"> 
    
      <input type="text" class="form-control" value="<%out.println(emp.getEphone());%>"   name="ephone" id="pnumber" placeholder="Enter Phone Number" pattern="[789][0-9]{9}" maxlength="10" required>
    </div>
    </div>
  
	<div class="form-group">
    <label class="control-label col-sm-3" for="pwd">DOB <span style=color:red>*</span></label>
    <div class="col-sm-6">
    
      <input type="text" class="form-control" value="<%out.println(emp.getEdob());%>" name="edob" id="dob" placeholder="Date Of Birth" required>
    </div>
    </div>
  
  <div class="form-group">
  <div class="bloodgroup">
    <label class="control-label col-sm-3" for="bloodgroup">BloodGroup <span style=color:red>*</span></label>
    <div class="col-sm-6">
    
     <select class="form-control" name="eblood" id="bgroup"  required="">
     
	 <option value=""><%out.println(emp.getEblood()); %></option>
    <option value="apos">A+</option>
	<option value="anag">A-</option>
	<option value="bpos">B+</option>
	<option value="bnag">B-</option>
	<option value="abpos">AB+</option>
	<option value="abnag">AB-</option>
	<option value="opos">O+</option>
	<option value="onag">O-</option>
  </select>
    </div>
	 </div>
	 </div>
	
 <div class="form-group">
    <label class="control-label col-sm-3" for="pwd">Email-Id <span style=color:red>*</span></label>
    <div class="col-sm-6">
    
      <input type="text" class="form-control" readonly="readonly" value="<%out.println(emp.getEemail()); %>" name="eemail" id="email" required placeholder="Enter Email-Id" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{3,3}$">
    </div>
  </div>
  
  <% } %>
   <div class="form-group"> 
    <div class="col-sm-12">
      <button type="submit" class="btn btn-success center-block"  onclick="return validate(form)"><span class="glyphicon glyphicon-upload"></span>   Update</button>
	</div>
	</div>
	
</form>
</fieldset>
</div>
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