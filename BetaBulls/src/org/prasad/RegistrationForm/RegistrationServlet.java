package org.prasad.RegistrationForm;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	static int status=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String repassword=request.getParameter("repassword");
		String password=request.getParameter("password");
		String mailid=request.getParameter("mailid");
		String ph=request.getParameter("mobile");
		double mobile=Double.parseDouble(ph);
		
		/*SimpleDateFormat formatter = new SimpleDateFormat("mm-dd-yyyy");
        Date dob=null;
        try
        {
        	dob=formatter.parse(request.getParameter("dob"));
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        System.out.println(dob.toString()); */
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String pin=request.getParameter("zip");
		double zipcode=Double.parseDouble(pin);
		
	    //int status=RegistrationForm.register(firstname,lastname,mailid,password,mobile,dob,gender,address,city,state,zipcode,repassword);
		if(password.equals(repassword))
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
			ps.setDouble(11,zipcode);
			ps.setString(12,repassword);
	
			
			status=ps.executeUpdate();
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	    
		if(status>0)
		{
			
			out.print("<html>");
			out.print("<body>");
			out.print("<h5>");
			out.print("<font color='blue'><font size='4'>");
			out.print("REGISTERED SUCCESSFULLY</h5></font></font>");
			out.print("</body>");
			out.print("</html>");
								
			//request.setAttribute("welcome","WELCOME! YOU HAVE BEEN REGISTERD");
			RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");
			rd.include(request, response);
		}
		else{
			out.print("<html>");
			out.print("<body>");
			out.print("<h2>");
			out.print("<font color='blue'><font size='4'>");
			out.print("Sorry,Registration failed. please try later</h2></font></font>");
			out.print("</body>");
			out.print("</html>");
			RequestDispatcher rd=request.getRequestDispatcher("RegistrationForm.jsp");
			rd.include(request, response);
		}
		}
		else{
			out.print("<html>");
			out.print("<body>");
			out.print("<h2>");
			out.print("<font color='orange'><font size='4'>");
			out.print("Password and RePassword Must be Same</h2></font></font>");
			out.print("</body>");
			out.print("</html>");
			
			RequestDispatcher rd=request.getRequestDispatcher("RegistrationForm.jsp");
			rd.include(request, response);
		}
	out.close();	
	}
	}

