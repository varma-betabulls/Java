/*package org.prasad.SendEmail;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

public class SendMail {

	
	public static void main(String[] args) {
		SendGrid sendgrid = new SendGrid("hanuman.kachwa", "HEY_RAM@87");

	    SendGrid.Email sendemail = new SendGrid.Email();
	    sendemail.addTo("kveeraprasadk@gmail.com ");
	    sendemail.setFrom("no-reply@doubledatingconnection.com");
	    sendemail.setSubject("Sending an Email Using SendGrid");
	    sendemail.setText("sending an email using send grid");

	    try {
	      SendGrid.Response response = sendgrid.send(sendemail);
	      System.out.println(response.getMessage());
	      
	    }
	    catch (SendGridException e) {
	      System.err.println(e);
	     
	    }

	}

}
*/