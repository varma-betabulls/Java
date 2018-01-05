

function validate(form)/*function to check */
{



 var pwd1=form.cpwd.value;
 var pwd2=form.npwd.value;
 var pwd3=form.rnpwd.value;
 /*the following code Changing the Passwords*/
 if(pwd1 =="")
 {
 alert("Please enter current password");/*display error message*/
 $("#cpwd").focus(); 
  return false;
 }
 else if(pwd2 =="")
  {
    alert("Please enter new password");/*displays error message*/
	$("#npwd").focus(); 
	return false;

  }
  else if(pwd1==pwd2)
  {
    alert("Both current password and new password must not be same");/*displays error message*/
	$("#npwd").focus(); 
	return false;

  }
 
  else if(pwd3 =="")
  {
    alert("Please enter re-enter new password");/*displays error message*/
	$("#rnpwd").focus();
	return false;
  }
 

 
  
   else if(pwd2!=pwd3)
 {
 
 
   alert("Both new password and re-enter new password must be same");/*displays error message*/
   $("#rnpwd").focus();
 return false;
  }
  
  
 else {
	 alert("Your password sucessfully changed");/*displays error message*/
   return true;
  }
}

	  