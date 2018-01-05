<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page language="java" import="java.util.*"%>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="org.prasad.AddEmployee.EmployeePojo" %>
    <% List<EmployeePojo> cList = (ArrayList<EmployeePojo>)request.getAttribute("edata");%>
    
<% EmployeePojo listleave = new EmployeePojo(); %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>List Leave Position</title>
     
	   <link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   
   <link rel="stylesheet" type="text/css" href="resources/css/custom.css">
   <script src="resources/javascript/ListLeavePosition.js"></script>
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
                        <li><a href="HomeServlet" class="">Dashboard</a></li>
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
                        <li class=" dropdown active">
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
	<div class="container" style="min-height:430px">
<div class="row">
<div class="form addemployee  " style="margin: 0 auto 25px; margin-top:35px;" >
<fieldset style="min-height: 380px;">
		<legend>Manage Leaves</legend>
<form class="form-horizontal" role="form" method="get" action="MangLvServlet" >
  
 
  <div class="col-sm-12 form-group">
  
    <label class="control-label col-sm-2" for="employeeid">Enter Year</label>
    <div class="col-sm-6">
      <select class="form-control" id="sel1" name="fdate" >
    <option value="">  Year  </option>
	<option value="2010">2010</option>
	<option value="2011">2011</option>
	<option value="2012">2012</option>
	<option value="2013">2013</option>
	<option value="2014">2014</option>
	<option value="2015">2015</option>
	<option value="2016">2016</option>
	<option value="2017">2017</option>
	<option value="2018">2018</option>
	<option value="2019">2019</option>
	<option value="2020">2020</option>
	<option value="2021">2021</option>
	<option value="2022">2022</option>
	<option value="2023">2023</option>
	<option value="2024">2024</option>
	<option value="2025">2025</option>
	<option value="2026">2026</option>
	<option value="2027">2027</option>
	<option value="2028">2028</option>
	<option value="2029">2029</option>
	<option value="2030">2030</option>
	<option value="2031">2031</option>
	<option value="2032">2032</option>
	<option value="2033">2033</option>
	<option value="2034">2034</option>
	<option value="2035">2035</option>
	<option value="2036">2036</option>
	<option value="2037">2037</option>
	<option value="2038">2038</option>
	<option value="2039">2039</option>
	<option value="2040">2040</option>
	 </select>
	 </div>
    </div>
  <div class="col-sm-12 form-group">
    <label class="control-label col-sm-2" for="employeeid">Employee Name</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="sel1" placeholder="Employee Name" name="ename" >
      </div>
    
    
 <button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-search "></span>   Search</button>
  </div>
 
 
  <br> 
  
<h4 align="left">Leaves Year : <%=request.getAttribute("yrs") %></h4>
 
<table class="table table-bordered table table-striped" border="2">
    <thead>
  <tr style="background-color:silver";>
        
       
  <th><font color='Red'>EMP ID</font></th>
  <th><font color='Red'>EMP NAME</font></th>
  
  <th><font color='Red'>PREV LEAVES</font></th>
  <th><font color='Red'>SICK LEAVES</font></th>
  <th><font color='Red'>CASUAL LEAVES</font></th>
  <th><font color='Red'>TOTAL LEAVES</font></th>
  <th><font color='Red'>ACTION</font></th></tr></thead>
  
  <% for(EmployeePojo cPojo:cList) { %>
  
<tr>
<td><%out.println(cPojo.getEid()); %></td>
<td><%out.println(cPojo.getEname());%></td>

<td><%out.println(cPojo.getPrevleave());%></td>
<td><%out.println(cPojo.getSickleave());%></td>
<td><%out.println(cPojo.getCasualleave());%></td>
<td><%out.println(cPojo.getTot());%></td>
<td><a href="ManageLeaveServlet?action=edit&ename=<%out.println(cPojo.getEname()); %>&year=<%=request.getAttribute("yrs")%>">Update</a>|
                    <a href="ManageLeaveServlet?action=delete&ename=<%out.println(cPojo.getEname()); %>&year=<%=request.getAttribute("yrs")%>">Delete</a></td>

<% } %>
</tr>

</table>
 
  
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