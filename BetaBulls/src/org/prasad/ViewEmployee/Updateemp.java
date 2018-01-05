package org.prasad.ViewEmployee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

import org.prasad.DBConn.DBUtil;

public class Updateemp {
static int status=0;
	
	public static int modify(String eid,String ename,String fathername,String eaddress,double epin,double ephone,String edob,String eblood,String eemail,String edesg,String edoj)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			PreparedStatement ps=con.prepareStatement("update RegEmp set ename=?,fathername=?,eaddress=?,epin=?,ephone=?,edob=?,eblood=?,eemail=?,edesg=?,edoj=? where eid=?");
			 
			/* java.util.Date utilDate = edob;
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    java.util.Date util1 = edoj;
		    java.sql.Date sql1 = new java.sql.Date(util1.getTime());
			
			*/
			 //int eno=DriverManager.getprimarykey();
			//ps.setInt(1,eno);
		    ps.setString(11,eid);
			ps.setString(1,ename); 
			ps.setString(2,fathername);
			ps.setString(3,eaddress);
			ps.setDouble(4,epin);
			ps.setString(9, edesg);
			ps.setString(6, edob);
			ps.setDouble(5,ephone);
			ps.setString(10,edoj);
			ps.setString(7,eblood);
			ps.setString(8,eemail);
			
			status=ps.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return status;
	}
}
