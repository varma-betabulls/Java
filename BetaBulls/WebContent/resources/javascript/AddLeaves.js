

function sum() {
       var txtFirstNumberValue = document.getElementById('leaves').value;
       var txtSecondNumberValue = document.getElementById('sick').value;
       var txtThirdNumberValue = document.getElementById('casual').value;
       if (txtFirstNumberValue == "")
           txtFirstNumberValue = 0;
       if (txtSecondNumberValue == "")
           txtSecondNumberValue = 0;
     if (txtThirdNumberValue == "")
           txtThirdNumberValue = 0;

       var result = parseFloat(txtFirstNumberValue) + parseFloat(txtSecondNumberValue)+parseFloat(txtThirdNumberValue);
       if (!isNaN(result)) {
           document.getElementById('total').value = result;
       }
   }
   function check(form)/*function to check userid & password*/
{
 /*the following code checkes whether the entered userid and password are matching*/
 if(form.sel1.value == "")
  {
    alert("Please select year");/*displays error message*/
  }
  else if(form.leaves.value=="")
  {
  alert("Please fill previlleged leaves ");
 
  }
  else if(form.sick.value=="")
  {
  alert("Please fill sick leaves");
  }
   else if(form.casual.value=="")
  {
  alert("Please fill casual eaves");
  }
 else
 {
 alert("Your details saved sucessfully");
   return true;
  }
}

