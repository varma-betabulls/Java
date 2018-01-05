<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RegistrationForm</title>
<meta charset="utf-8">
 <link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
   
   <link rel="stylesheet" type="text/css" href="resources/css/custom1.css">
      <script src="resources/javascript/reg.js"></script>
   <link rel="script" type="text/javascript" href="resources/javascript/javascript.js">
   <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<script type="text/javascript" src="http://www.clubdesign.at/floatlabels.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="script" type="text/javascript" href="resources/js/javascriptexp.js">
</head>

<div class="container-fluid">

        <div class="row centered-form">
        <div class=" col-md-6 col-md-offset-3">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h1 class="panel-title" align="center"><b>REGISTRATION FORM</b></h1>
			    		<h4 align="right"><a href="Index.jsp">Login</a></h4>
			 			</div>
			 			
			 			<div class="panel-body">
			    		<form role="form" name="myForm" method="get" action="RegistrationServlet" onclick="check(form)">
						<div class="col-sm-10 col-md-offset-1">
			    			<div class="row">
			    			
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
								<label>First Name</label>
			                <input type="text" name="firstname" id="fname" class="form-control input-sm floatlabel" placeholder="First Name" required > 
			    					</div>
			    				</div>
							 <div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
									<label>Last Name</label>
			    						<input type="text" name="lastname" id="lname" class="form-control input-sm" placeholder="Last Name" required>
			    					</div>
			    				</div>
							 <div class="col-xs-6 col-sm-6 col-md-6">
			    			<div class="form-group">
							<label>Email Address</label>
			    				<input type="email" name="mailid" id="email" class="form-control input-sm" placeholder="Email Address" required>
			    			</div>
                              </div>
						    <div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
									<label>Password</label>
			    						<input type="password" name="password" id="password"  class="form-control input-sm" placeholder="Password" required>
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
									<label>Confirm Password</label>
			    						<input type="password" name="repassword" id="confpwd" class="form-control input-sm" placeholder="Confirm Password" required>
			    					</div>
			    				</div>
							
						       <div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
									<label>Phone Number</label>
			    						<input type="tel" name="mobile" id="pnumber" class="form-control input-sm" placeholder="Phone Number" min="1" pattern="[789][0-9]{9}" maxlength="10" required>
			    					</div>
			    				</div>
						   <div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
									<label>Date Of Birth</label>
			    						<input type="Date" name="dob" id="dob" class="form-control input-sm" placeholder="Date Of Birth" required>
			    					</div>
			    				</div>
						<div class="col-sm-12 form-group">
						    <label>Gender</label>
						        <div class="row" >
                                     <div class="col-sm-4">
                                         <label class="radio-inline" >
                                         <input type="radio" name="gender" id="male" value="male"  required="required"> Male
                                         </label>
                                     </div>
                            <div class="col-sm-4">
                                <label class="radio-inline">
                                <input type="radio" name="gender" id="female"value="Female" required="required" >Female
                                </label>
                            </div>
                        </div>
						</div>
						</div>
						
										
						<div class="form-group">
							<label>Address</label>
							<textarea placeholder="Enter Address" name="address" id="address"rows="3" class="form-control" required></textarea>
						</div>
						   <div class="row">
								<div class="col-sm-4 form-group">
								   <label>City</label>
								    <input type="text" id="city" name="city" placeholder="City Name" class="form-control" required>
							    </div>	
							<div class="col-sm-4 form-group">
								<label>State</label>
								<input type="text" id="state" name="state" placeholder="State Name" class="form-control" required>
							</div>	
							    <div class="col-sm-4 form-group">
								    <label>Zip</label>
								    <input type="number" class="form-control" name="zip" id="zip" placeholder="Zip Code" pattern="[0-9]{6}" maxlength="6"required>
							    </div>		
						    </div>
							<div class="col-md-4 col-md-offset-2">
							<div id="submit">
						<input type="submit" class="btn btn-lg btn-info center-block" value="Register" />
								</div>	</div>
						<div class="col-sm-4">				
					<div id="reset">
					   
					   <input type="reset" class="btn btn-lg btn-info center-block" value="Reset" />
					   
					</div>
					
					</div>
					</div>
					</form>
					</div>
					</div>
					</div>
					</div>
					</div>
					
			    		
			    	
</body>
</html>