
var data=JSON.parse(localStorage.getItem("details"));
if((data=="")||(data==null))
{
document.getElementById("email").value="";
document.getElementById("password").value="";
}
else
{
document.getElementById("email").value=data[0];
document.getElementById("password").value=data[1];
}
var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z]{3,3})+$/;
function check(form)/*function to check userid & password*/
{
 var x = document.getElementById("remember123").checked;
 /*the following code checkes whether the entered userid and password are matching*/
  if(form.email.value == ""){
	alert("Please fill e-mail adress");
	$("#email").focus();
	return false;
	}
 else if (!filter.test(email.value)) {
    alert('Please provide a valid email address');
	$("#email").focus();
    return false;
	}
	else if(form.password.value==""){
	alert("Please Fill Password");
	return false;
	} 
	else{
	localStorage.clear();
	var details=[form.email.value,form.password.value]
		localStorage.setItem("details",JSON.stringify(details));

 if(!x)
{
localStorage.clear();
}
		
 //window.open("Dashboard.html");
 //return true;

 }
 
}

