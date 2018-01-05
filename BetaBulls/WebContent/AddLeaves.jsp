<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Leaves</title>
<link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   
   <link rel="stylesheet" type="text/css" href="resources/css/custom.css">
    <script src="resources/javascript/AddLeaves.js"></script>
   <link rel="script" type="text/javascript" href="resources/javascript/javascript.js">
   <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
</head>
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
<form method="get" action="AddLeaveServlet" onclick="check(this.form)" class="form-horizontal" role="form">
<div class="container" style="min-height:430px">
<div class="row">
<div class="form addemployee  " style="margin: 0 auto 25px; margin-top:35px;" >
<fieldset style="min-height: 380px;">
		<legend>Add Leaves</legend>

  <div class="form-group">
  
 
    <label class="control-label col-sm-3" for="year">Select Year <span style=color:red>*</span><strong></strong></label>
    <div class="col-sm-9">
     <select class="form-control" id="sel1" name="yrs" required >
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
	<option value="2020">2021</option>
	<option value="2020">2022</option>
	<option value="2020">2023</option>
	<option value="2020">2024</option>
	<option value="2020">2025</option>
	<option value="2020">2026</option>
	<option value="2020">2027</option>
	<option value="2020">2028</option>
	<option value="2020">2029</option>
	<option value="2020">2030</option>
	<option value="2020">2031</option>
	<option value="2020">2032</option>
	<option value="2020">2033</option>
	<option value="2020">2034</option>
	<option value="2020">2035</option>
	<option value="2020">2036</option>
	<option value="2020">2037</option>
	<option value="2020">2038</option>
	<option value="2020">2039</option>
	<option value="2020">2040</option>
	 </select>
    </div>

  </div>
  
  <div class="form-group">
    <label class="control-label col-sm-3" for="leaves">Employee Name<span style=color:red>*</span><strong></strong></label>	
    <div class="col-sm-9">
      <input type="text" class="form-control" name="ename" id="ename" placeholder="Employee Name" required>
    </div>
  </div>
  
    <div class="form-group">
    <label class="control-label col-sm-3" for="leaves">Previlleged Leaves<span style=color:red>*</span><strong></strong></label>	
    <div class="col-sm-9">
      <input type="number" min="0" step="any" class="form-control" name="pleave" id="leaves" placeholder="Previlleged Leaves" onkeyup="sum();" required>
    </div>
  </div>
  
    <div class="form-group">
    <label class="control-label col-sm-3" for="sick">Sick Leaves<span style=color:red>*</span><strong></strong></label>
    <div class="col-sm-9">
      <input type="number" min="0" step="any"class="form-control" name="sleave" id="sick" placeholder="Sick Leaves" onkeyup="sum();" required>
    </div>
  </div>
  
  
  
  
    <div class="form-group">
    <label class="control-label col-sm-3" for="leaves">Casual Leaves<span style=color:red>*</span><strong></strong></label>
    <div class="col-sm-9">
      <input type="number"  min="0" step="any"class="form-control" name="cleave" id="casual" placeholder="Casual Leaves" onkeyup="sum();" required>
    </div>
  </div>
    <div class="form-group">
    <label class="control-label col-sm-3" for="total" step="any">Total<span style=color:red>*</span><strong></strong></label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="total" placeholder="Total" name="total" readonly>
    </div>
  </div>
   <div class="form-group"> 
    <div class="col-sm-12">
	<div style="text-align:center;">
				
				<button type="submit" class="btn btn-success" ><span class="glyphicon glyphicon-saved"></span> SAVE</button>
				<button type="reset" class="btn btn-primary" >CANCEL</button>
				</div>
	 
   </div>
      
	  <!--a href="#" class="btn btn-primary btn-md" style="align:center">
      <span class="glyphicon glyphicon-ok"></span> Upload
    </a-->
</div>
</div>
  
  </div>
  </fieldset>
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