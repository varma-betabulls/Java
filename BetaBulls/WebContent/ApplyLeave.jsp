<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply Leave</title>
<link rel="shortcut icon" href="resources/images/favicon.ico" type="resources/image/x-icon">
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
                        <li><a href="HomePage.jsp" class="">Dashboard</a></li>
                        <li class=" dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Employees <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class=" dropdown">
                                    <!--<a href="#" class="dropdown-toggle " data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">List Employees</a>-->
                                
                                <li><a href="AddEmployee.jsp">Add Employee</a></li>
								 
								 <li><a href="ViemEmployees.jsp">List Of Employees </a></li>
								 
                            </ul>
							</li>
                            
                        <!--li><a href="#">Manage Employees</a></li-->
                        <li class=" dropdown active">
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
                                <!--li><a href="#">Bulk Upload</a></li-->
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
                                <li><a href="ProfileServlet">My Profile</a></li>
								
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
<div class="form addemployee col-sm-offset-3 col-sm-8" >


<form class="form-horizontal" role="form"  method="get" action="ApplyLeaveServlet" name="ApplyLeave">
  
  <div class="form-group">
    <label class="control-label col-sm-3" for="to">To</label>
    <div class="col-sm-9">
       <select class="form-control" id="sel1" name="hr">
    <option>  To  </option>
	<option value="hr">HR</option>
	<option value="manager">Manager</option>
	<option value="tl">TL</option>
	 </select>
    </div>
  </div>
  
 <div class="form-group">
  <label class="control-label col-sm-3" for="leaves">EmployeeId</label>
  <div class="col-sm-9">
      <input type="text" class="form-control" id="empid" placeholder="Employeeid" name="eid" />
    </div>
    </div>
    <div class="form-group">
  <label class="control-label col-sm-3" for="leaves">EmployeeName</label>
  <div class="col-sm-9">
      <input type="text" class="form-control" id="empname" placeholder="EmployeeName" name="ename" />
    </div>
    </div>
  
  <div class="form-group">
  <label class="control-label col-sm-3" for="leaves">From</label>
  <div class="col-sm-9">
      <input type="date" class="form-control" id="from" placeholder="From Date" name="fromdate" />
    </div>
    </div>
    <div class="form-group">
  <label class="control-label col-sm-3" for="leaves">To</label>
  <div class="col-sm-9">
      <input type="date" class="form-control" id="todate" placeholder="To Date" name="todate" />
    </div>
    </div>
    
    <div class="form-group">
    <label class="control-label col-sm-3" for="leaves">Previlleged Leaves</label>	

    <div class="col-sm-9">
      <input type="text" class="form-control" id="previlleged" placeholder="Previlleged Leaves" name="previlleged" />
    </div>
  </div>
  
    <div class="form-group">
    <label class="control-label col-sm-3" for="sick">Sick Leaves</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="sick" placeholder="Sick Leaves" name="sickleave" />
    </div>
  </div>
  
    <div class="form-group">
    <label class="control-label col-sm-3" for="leaves">Casual Leaves</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="casual" placeholder="Casual Leaves" name="casual" />
    </div>
  </div>
  
    <div class="form-group">
    <label class="control-label col-sm-3" for="total">Total</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="total" placeholder="Total" name="total"  />
    </div>
  </div>
  
  
   <div class="form-group"> 
    <div class="col-sm-offset-3 col-sm-9">
      <div class="butt7">
      <input type="submit" class="btn btn-success" value="Save" /></div>
	  <!--a href="#" class="btn btn-primary btn-md" style="align:center">
      <span class="glyphicon glyphicon-ok"></span> Upload
    </a-->
</div>
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