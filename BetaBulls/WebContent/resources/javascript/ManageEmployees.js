
var mailformat = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z]{3,3})+$/;
 var mob = /^([0|\+[0-9]{1,5})?([7-9][0-9]{9})$/;
 var letterNumber = /^[0-9a-zA-Z]+$/; 

   function validate(form){
if(form.eid.value == ""){
alert("Please fill employee id");
$("#eid").focus();
return false;
}
 else if(form.ename.value=="" ) {
 alert("Please fill employee name");
 $("#ename").focus();
 return false;
 }
 else if (letterNumber.test(ename.value) == false){
	alert("Please fill with alphanumerics");
	$("#ename").focus();
	return false;
	}
 else if(form.fname.value=="") {
 alert("Please fill fathersname");
 $("#fname").focus();
 return false;
 

 }
 else if (letterNumber.test(fname.value) == false){
	alert("Please fill with alphanumerics");
	$("#fname").focus();
	return false;
	}
 else if(form.adress.value==""){
 alert("Please fill employee adress");
 $("#adress").focus();
 return false;
 
 }
  else if(form.pincode.value==""){
 alert("Please select pincode");
 $("#pincode").focus();
 return false;
 
 }
 else if(form.pincode.value.length !=6){
alert("Pincode must be 6 digts.!");
document.getElementById('pincode').focus();
return false;
 
}

 else if(form.pnumber.value==""){
 alert("Please fill mobile number");
 $("#pnumber").focus();
 return false;
 
  }
  else if(form.pnumber.value.length != 10) {
    alert("Phone number must be 10 digits.");
	$("#pnumber").focus();
	return false;
	
}
else if (mob.test(pnumber.value) == false){
	alert("Please fill valid mobile number ");
	$("#pnumber").focus();
	return false;
	}


 else if(form.dob.value==""){
 alert("Please select dateofbirth");
 $("#dob").focus();
 return false;

 }
 else if(form.bgroup.value==""){
 alert("Please select blood group");
 $("#bgroup").focus();
 return false;
 
 }

 else if(form.email.value==""){
 alert("Please select email");
 $("#email").focus();
 return false;
 
 }
 else if (mailformat.test(form.email.value)!=true) {
   alert("Invalid email") ;
   $("#email").focus();
return false;
  }  
else{
alert("Your details updated  sucessfully");
return true;
}
}

