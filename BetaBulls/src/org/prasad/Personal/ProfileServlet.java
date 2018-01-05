package org.prasad.Personal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prasad.AddEmployee.EmployeePojo;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		  HttpSession session=request.getSession();
			String user=(String)session.getAttribute("name");
			System.out.println(user);
				
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			PreparedStatement ps=con.prepareStatement("select firstname,lastname,mailid,mobile,dob,address,city,state,zipcode from empregistration where mailid=?");
			ps.setString(1, user);
			
			//out.print("<table width=25% border=1>");
         // out.print("<center><h1>Result:</h1></center>");
          
          ResultSet rs=ps.executeQuery();
          RequestDispatcher dispatcher=null;
          //ResultSetMetaData rsmd=rs.getMetaData();
			while(rs.next())
			{		
				
				String fname=rs.getString("firstname");
				String lname=rs.getString("lastname");
				String mailid=rs.getString("mailid");
				String mobile=rs.getString("mobile");
				String dob=rs.getString("dob");
				String address=rs.getString("address");
				String city=rs.getString("city");
				String state=rs.getString("state");
				String zip=rs.getString("zipcode");
				
				request.setAttribute("fname", fname);
				request.setAttribute("lname", lname);
				request.setAttribute("mailid", mailid);
				request.setAttribute("mobile", mobile);
				request.setAttribute("dob", dob);
				request.setAttribute("address", address);
				request.setAttribute("city", city);
				request.setAttribute("state", state);
				request.setAttribute("zip", zip);
              }
			System.out.println("result is::");
							
			dispatcher = request.getRequestDispatcher("ProfileEdit.jsp"); 
			dispatcher.forward(request, response);
			
			
        //out.print("</table>");

       }catch (Exception e2)
         {
             e2.printStackTrace();
         }

       finally{out.close();
       }
       
	}

}
