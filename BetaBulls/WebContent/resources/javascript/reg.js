
	var email = document.getElementById('email');
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{3,3})+$/;
	var mob = /^([0|\+[0-9]{1,5})?([7-9][0-9]{10})$/;
	var regex = /^[0-9a-zA-Z]+$/; 
	 //var textbox = document.getElementById("zip");
	
	
	
	function check(form){
	
	
	
	if(form.fname.value == ""){
	alert("Please fill first name");
	$("#fname").focus();
	return false;
	
	}
	else if (regex.test(fname.value) == false){
	alert("Please fill with alphanumeric");
	$("#fname").focus();
	return false;
	}
	else if(form.lname.value == ""){
	alert("Please fill last name");
	$("#lname").focus();
	return false;
	}
	else if (regex.test(lname.value) == false){
	alert("Please fill with alphanumerics");
	$("#lname").focus();
	return false;
	}
	else if(form.eid.value == ""){
	alert("Please fill employee id");
	$("#eid").focus();
	return false;
	}
	else if(form.dob.value == ""){
	alert("Please select date of birth");
	$("#dob").focus();
	    return false;

	}
	else if(form.pnumber.value == ""){
	alert("Please fill mobile number");
	$("#pnumber").focus();
	return false;
	}
	else if (mob.test(pnumber.value) == false){
	alert("Please fill valid mobile number ");
	$("#pnumber").focus();
	return false;
	}
	else if(form.pnumber.value.length != "10"){
	alert("Make sure the Phone number must Be 10 characters long");
	$("#pnumber").focus();
	return false;
	}
	
	else if(form.email.value == ""){
	alert("Please fill e-mail adress");
	$("#email").focus();
	return false;
	 }
	else if (!filter.test(form.email.value)) {
    alert('Please provide a valid email address');
    $("#email").focus();
    return false;
	}
	else if(form.password.value == ""){
	alert("Please fill password");
	$("#password").focus();
	return false;
	}
	else if(form.confpwd.value == ""){
	alert("Please fill confirm password");
	$("#confpwd").focus();
	return false;
	}
	else if(form.confpwd.value != form.password.value ){
	alert("Password and confirm password must be same");
	$("#confpwd").focus();
	return false;
	}
	
	else if ((form.gender[0].checked == false)&& (form.gender[1].checked == false) ){
	alert("Please select either male or female");
	$("#male").focus();
	return false;
	}
	
	else if(form.address.value == ""){
	alert("Please fill address");
	$("#address").focus();
	return false;
	}
	else if(form.city.value == ""){
	alert("Please fill city name");
	$("#city").focus();
	return false;
	}
	else if(form.state.value == ""){
	alert("Please fill state name");
	$("#state").focus();
	return false;
	}
	else if(form.zip.value == ""){
	alert("Please fill zip code");
	$("#zip").focus();
	return false;
	}
	
	else if(form.zip.value.length != "6"){
	alert("Make sure the zip code must be 6 characters long");
	document.getElementById('zip').focus();
	return false;
	}
	else{
	
	alert("Your registration is sucessfully completed");
	window.location.reload();
	window.open('/premium');
	return true;
	}
	
	}
	