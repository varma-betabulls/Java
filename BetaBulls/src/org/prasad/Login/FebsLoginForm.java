package org.prasad.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FebsLoginForm {
	static int status=0;
	String name=null;
	public static int isValid(String eid,String password)
	{
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			PreparedStatement ps=con.prepareStatement("select eid,password from EmpRegistration where eid=? and password=?");
			
			
		    ps.setString(1,eid);
			ps.setString(2,password);
			
			
			status=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}
	
}
