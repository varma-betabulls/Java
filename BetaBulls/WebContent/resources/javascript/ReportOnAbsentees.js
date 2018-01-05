
	   function check(form)/*function to check select year*/
{
 /*the following code checkes whether user select year or not*/
 if(form.sel1.value == "" && form.sel2.value=="")
 {
 alert("please select year and month");/*display error message*/
 return false;
 }
 else if(form.sel1.value == "")
  {
    alert("Please select year");/*displays error message*/
	return false;
  }
  else if(form.sel2.value == "")
  {
    alert("Please select month");/*displays error message*/
	return false;
  }
 else
 {
   alert("Your details saved sucessfully!");
   return true;
  }
}

function validate(form)/*function to check select year*/
{
 /*the following code checkes whether user select year or not*/
 if(form.sel1.value == "" && form.sel2.value=="")
 {
 alert("Please select year and month");/*display error message*/
 return false;
 }
 else if(form.sel1.value == "")
  {
    alert("Please select year");/*displays error message*/
	return false;
  }
  else if(form.sel2.value == "")
  {
    alert("Please select month");/*displays error message*/
	return false;
  }
 else
 {
   alert("Your details sucessfully converted into pdf format");
   return true;
  }
}
