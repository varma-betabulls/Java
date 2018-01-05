package org.prasad.Personal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

public class ProfileUpdate {
static int status=0;
	
	public static int modify(String fname,String lname,String mailid,double mobile,String address,String edob,String city,String state,double zip)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			PreparedStatement ps=con.prepareStatement("update empregistration set firstname=?,lastname=?,mobile=?,dob=?,address=?,city=?,state=?,zipcode=? where mailid=?");
			 
			//java.util.Date utilDate = edob;
		    //java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		  
			
			 //int eno=DriverManager.getprimarykey();
			//ps.setInt(1,eno);
		 	ps.setString(1,fname); 
			ps.setString(2,lname);
			ps.setDouble(3,mobile);
			ps.setString(4, edob);
			ps.setString(5, address);
			ps.setString(6, city);
			ps.setString(7, state);
			ps.setDouble(8,zip);
			ps.setString(9, mailid);
			
			
			
			
			status=ps.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return status;
	}
}
