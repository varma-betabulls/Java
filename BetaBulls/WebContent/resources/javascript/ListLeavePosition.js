
 function check(form)/*function to check userid & password*/
{
 /*the following code checkes whether the entered userid and password are matching*/
 if(form.sel1.value == "")
  {
    alert("Please select year");/*displays error message*/
  }
 else
 {
   alert("Details sucessfully saved..!");
   return true;
  }
}
function validate(form)/*function to check userid & password*/
{
 /*the following code checkes whether the entered userid and password are matching*/
 if(form.sel1.value == "")
  {
    alert("Please select year");/*displays error message*/
  }
 else
 {
   alert("Details sucessfully converted into pdf format");
   return true;
  }
}