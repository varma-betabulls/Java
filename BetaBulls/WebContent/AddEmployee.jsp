<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add Employee</title>
<link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   
   <link rel="stylesheet" type="text/css" href="resources/css/custom.css">
    <script src="resources/javascript/AddEmployee.js"></script>
   <link rel="script" type="text/javascript" href="resources/javascript/javascript.js">
   <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<link href="resources/css/style.css" rel="stylesheet" type="text/css">

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
                        <li><a href="HomePage.jsp" class="">Dashboard</a></li>
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
		<div class="form addemployee " style="margin: 0 auto 25px; margin-top:35px;">
		<fieldset style="min-height: 490px;">
		<legend>Add Employee</legend>
<form class="form-horizontal" role="form" name="myForm" method="get" action="AddEmpServlet" onclick="return validate(form)">

  <div class="form-group">
    <label class="control-label col-sm-3" for="employeeid">Employee Id <span style=color:red>*</span></label>
    <div class="col-sm-9">
	<div class="input-group">
      <input type="text" class="form-control" id="eid" name="eid" placeholder="Enter Employee Id"  minlength="4" maxlength="6"    required/>
    <span class="input-group-addon" style="border-left: none;">
	  <span class="glyphicon glyphicon-user"></span>
	  </span>
	  </div>
	</div>
  </div>
  
 <div class="form-group">
    <label class="control-label col-sm-3" for="pwd">Employee Name <span style=color:red>*</span></label>
    <div class="col-sm-9"> 
	<div class="input-group">
      <input type="text" class="form-control" id="ename" name="ename"  placeholder="Enter Employee Name" required>
    <span class="input-group-addon" style="border-left: none;">
	  <span class="glyphicon glyphicon-user"></span>
	  </span>
	  </div>
	</div>
	 </div>
	 
   <div class="form-group">
    <label class="control-label col-sm-3" for="pwd">Father Name <span style=color:red>*</span></label>
    <div class="col-sm-9">
	<div class="input-group">
      <input type="text" class="form-control" id="fname" name="fathername" placeholder="Enter Father Name" required>
	  <span class="input-group-addon" style="border-left: none;">
	  <span class="glyphicon glyphicon-user"></span>
	  </span>
	  </div>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-3" for="pwd">Address <span style=color:red>*</span></label>
    <div class="col-sm-9"> 
	<div class="input-group">
      <textarea class="form-control" rows="3" id="adress" name="eaddress" placeholder="Enter Address" required></textarea>
      <span class="input-group-addon" style="border-left: none;">
								<span class="fa fa-paper-plane"></span>
								
							</span>
    </div>
	</div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-3" for="pwd">PINCODE <span style=color:red>*</span></label>
    <div class="col-sm-9"> 
	<div class="input-group">
      <input type="pin" class="form-control" id="pincode" name="epin" placeholder="Enter PinCode" pattern="[0-9]{6}" maxlength="6"required>
    <span class="input-group-addon" style="border-left: none;">
								<span class="fa fa-paper-plane"></span>
								
		</div>					</span>
	</div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-3" for="pwd">Designation <span style=color:red>*</span></label>
    <div class="col-sm-9"> 
    <div class="input-group">
      <input type="text" class="form-control" name="edesg" id="edesg" placeholder="Enter Designation" required>
      <span class="input-group-addon" style="border-left: none;">
								<span class="fa fa-paper-plane"></span>
								
		</div>					</span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-3" for="pwd">Date of Joining <span style=color:red>*</span></label>
    <div class="col-sm-9"> 
    <div class="input-group">
      <input type="date" class="form-control" name="edoj" id="doj" placeholder="Date Of Joining" required>
      <span class="input-group-addon" style="border-left: none;">
								<span class="fa fa-paper-plane"></span>
								
		</div>					</span>
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-3" for="pwd">Phone Number <span style=color:red>*</span></label>
    <div class="col-sm-9"> 
	<div class="input-group">
      
	  <input type="tel" class="form-control" id="pnumber" name="ephone" placeholder="Enter Phone Number" pattern="[789][0-9]{9}" maxlength="10" required>
    <span class="input-group-addon" style="border-left: none;">
								<span class="glyphicon glyphicon-phone"></span>
							</span>
    </div>
	</div>
  </div>
	<div class="form-group">
    <label class="control-label col-sm-3" for="pwd">DOB <span style=color:red>*</span></label>
    <div class="col-sm-9"> 
	<div class="input-group">
      <input type="date" class="form-control" id="dob" name="edob" placeholder="Date Of Birth" required>
    <span class="input-group-addon" style="border-left: none;">
								<span class="fa fa-birthday-cake"></span>
								
							</span>
    </div>
	</div>
  </div>
  <div class="form-group">
  <div class="bloodgroup">
  
    <label class="control-label col-sm-3" for="bloodgroup">BloodGroup <span style=color:red>*</span></label>
    <div class="col-sm-9"> 
	<div class="input-group">
     <select class="form-control" id="bgroup" name="eblood" required="">
	 <option value="">Select Blood Group</option>
    <option value="apos">A +</option>
	<option value="anag">A -</option>
	<option value="bpos">B +</option>
	<option value="bnag">B -</option>
	<option value="abpos">AB +</option>
	<option value="abnag">AB -</option>
	<option value="opos">O +</option>
	<option value="onag">O -</option>
	
  </select>
   <span class="input-group-addon" style="border-left: none;">
								<span class="glyphicon glyphicon-tint"></span>
								
							</span>
    </div>
    </div>
	 </div>
	 </div>
 <div class="form-group">
    <label class="control-label col-sm-3" for="pwd">Email-Id <span style=color:red>*</span></label>
    <div class="col-sm-9">
<div class="input-group">	
      <input type="email" class="form-control" id="email" name="eemail" required placeholder="Enter Email-Id" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{3,3}$">
    <span class="input-group-addon" style="border-left: none;">
								<span class="glyphicon glyphicon-envelope"></span>
								
							</span>
    </div>
	</div>
  </div>
    
     
    <div style="text-align:center;">
      <button type="submit" class="btn btn-success" ><span class="glyphicon glyphicon-saved"></span> SAVE</button>
     
	
     
      <button type="cancel" class="btn btn-primary" > CANCEL</button>
	</div>
	
	
</form>
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