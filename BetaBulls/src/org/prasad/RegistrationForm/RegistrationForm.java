package org.prasad.RegistrationForm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

public class RegistrationForm {
static int status=0;
	
	public static int register(String firstname,String lastname,String mailid,String password,double mobile,String dob,String gender,String address,String city,String state,double zip,String repassword){
		{

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			PreparedStatement ps=con.prepareStatement("insert into EmpRegistration(firstname,lastname,mailid,password,mobile,dob,gender,address,city,state,zipcode,repassword) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			
		    ps.setString(1,firstname);
			ps.setString(2,lastname);
			
			ps.setString(4,password);
			ps.setString(3,mailid);
			ps.setDouble(5,mobile);
			
			/*java.util.Date utilDate = dob;
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    System.out.println("util:"+utilDate.toString());
		    System.out.println(sqlDate.toString()); */
			ps.setString(6,dob);
			
			ps.setString(7,gender);
			ps.setString(8,address);
			ps.setString(9,city);
			ps.setString(10,state);
			ps.setDouble(11,zip);
			ps.setString(12,repassword);
	
			
			status=ps.executeUpdate();
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return status;
		
	}

	}
}
