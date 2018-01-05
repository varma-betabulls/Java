
 
	  function validate(form)/*function to check select year*/
{
 /*the following code checkes whether user select year or not*/
 if(form.sel1.value == "" && form.sel2.value=="")
 {
 alert("Please select month and year");/*display error message*/
 }
 else if(form.sel1.value == "")
  {
    alert("Please select month");/*displays error message*/

  }
  else if(form.sel2.value == "")
  {
    alert("Please select year");/*displays error message*/

  }
   else if(form.uploadBox.value == "")
  {
    alert("Please upload your file");/*displays error message*/

  }
  
 else
 {
 alert("Your uplodaded data sucessfully");
   return true;
  }
}

	 