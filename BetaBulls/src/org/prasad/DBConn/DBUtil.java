package org.prasad.DBConn;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	    private static Connection connection = null;

	    public static Connection getConnection() {
	        if (connection != null)
	            return connection;
	        else {
	            try {
	                
	            	Class.forName("oracle.jdbc.driver.OracleDriver");
	    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
	    			
	            } catch (ClassNotFoundException e) {
	                e.printStackTrace();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            } 
	            return connection;
	        }

	    }

}
