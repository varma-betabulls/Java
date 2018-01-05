package org.prasad.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LoginForm {
	static int status=0;
	public static int isValid(String username,String password)
	{
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			PreparedStatement ps=con.prepareStatement("select mailid,password from EmpRegistration where mailid=? and password=?");
			
		    ps.setString(1,username);
			ps.setString(2,password);
						
			status=ps.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}

}
