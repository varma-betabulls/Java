
var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z]{3,3})+$/;
 var mob = /^([0|\+[0-9]{1,5})?([7-9][0-9]{9})$/;
 var letterNumber = /^[0-9a-zA-Z]+$/;
function validate(form){
if(form.prfusername.value ==""){
alert("Please fill username");
$("#prfusername").focus();
return false;
}

 else if(form.prffirstname.value=="" ) {
 alert("Please fill firstname");
 $("#prffirstname").focus();
 return false;
 }
 else if (letterNumber.test(prffirstname.value) == false){
	alert("Please fill with alphanumerics");
	$("#prffirstname").focus();
	return false;
	}
 else if(form.prflastname.value=="") {
 alert("Please fill lastname");
 $("#prflastname").focus();
 return false;

 }
 else if (letterNumber.test(prflastname.value) == false){
	alert("Please fill with alphanumerics");
	$("#prflastname").focus();
	return false;
	}
 else if(form.prfphonenumber.value==""){
 alert("Please fill mobile number");
 $("#prfphonenumber").focus();
 return false;
 
  }
    else if(form.prfphonenumber.value.length != 10)  {
    alert("Phone number must be 10 digits.");
	$("#prfphonenumber").focus();
	return false;
}
else if (mob.test(prfphonenumber.value) == false){
	alert("Please fill valid mobile number ");
	$("#prfphonenumber").focus();
	return false;
	}
else if(form.prfemailname.value==""){
 alert("Please select email");
 $("#prfemailname").focus();
 return false;
 
 }
 else if (!filter.test(prfemailname.value)) {
    alert('Please provide a valid email address');
    
	$("#prfemailname").focus();
    return false;
	}
 

else{
alert("Your details uploaded sucessfully");
return true;
}
}
