package org.prasad.AddEmployee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

import org.prasad.DBConn.DBUtil;

public class RegisterUser {
static int status=0;
	
	public static int register(String eid,String ename,String fathername,String eaddress,double epin,String edesg,String edoj,double ephone,String edob,String eblood,String eemail)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			PreparedStatement ps=con.prepareStatement("insert into RegEmp(eid,ename,fathername,eaddress,epin,edesg,edoj,ephone,edob,eblood,eemail) values(?,?,?,?,?,?,?,?,?,?,?)");
			 
			/* java.util.Date utilDate = edob;
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    java.util.Date util1 = edoj;
		    java.sql.Date sql1 = new java.sql.Date(util1.getTime());
			*/
			
			 //int eno=DriverManager.getprimarykey();
			//ps.setInt(1,eno);
		    ps.setString(1,eid);
			ps.setString(2,ename); 
			ps.setString(3,fathername);
			ps.setString(4,eaddress);
			ps.setDouble(5,epin);
			ps.setString(6, edesg);
			ps.setString(7, edoj);
			ps.setDouble(8,ephone);
			ps.setString(9,edob);
			ps.setString(10,eblood);
			ps.setString(11,eemail);
			
			
			
			status=ps.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return status;
	}
}
