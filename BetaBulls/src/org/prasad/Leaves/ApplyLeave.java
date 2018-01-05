/*package org.prasad.Leaves;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

public class ApplyLeave {
static int status=0;
	static int result=0;
	public static int applyLeave(String hr,String eid,String ename,Date fromdate,Date todate,String previlleged,String sickleave,String casual,String total)
	{
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			PreparedStatement ps=con.prepareStatement("insert into ApplyLeave values(?,?,?,?,?,?,?,?)");
			 
			java.util.Date utilDate = fromdate;
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    java.util.Date util1 = todate;
		    java.sql.Date sql1 = new java.sql.Date(util1.getTime());
			
			
			 //int eno=DriverManager.getprimarykey();
			//ps.setInt(1,eno);
		    ps.setString(1, hr);
		    ps.setString(2,eid);
			ps.setString(3,ename); 
			ps.setDate(4,sqlDate);
			ps.setDate(5,sql1);
			ps.setString(6, previlleged);
			ps.setString(7,sickleave);
			ps.setString(8,casual);
			ps.setString(9,total);
			
			status=ps.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return status;
}
	public static int send(String toid,String eid,String ename,Date fromdate,Date todate,String previlleged,String sickleave,String casual,String total)
	{
		SendGrid sendgrid = new SendGrid("hanuman.kachwa", "HEY_RAM@87");

	    SendGrid.Email sendemail = new SendGrid.Email();
	    sendemail.addTo(""+toid+"");
	    sendemail.setFrom("no-reply@doubledatingconnection.com");
	    sendemail.setSubject("ApplyLeave");
	    sendemail.setText("EmpId:"+eid+"EmpName:"+ename+"FromDate:"+fromdate+"ToDate:"+todate+"PrevillegedLeaves:"+previlleged+"SickLeaves:"+sickleave+"CasualLeaves:"+casual+"Total Leaves:"+total);

	    try {
	      SendGrid.Response response = sendgrid.send(sendemail);
	      System.out.println(response.getMessage());
	      
	    }
	    catch (SendGridException e) {
	      System.err.println(e);
	     
	    }
return result;
	}
	}
*/