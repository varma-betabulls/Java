package org.prasad.Personal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prasad.EmployeePojo.RegistrationPojo;

/**
 * Servlet implementation class PasswordChangeServlet
 */
public class PasswordChangeServlet extends HttpServlet {
	public static int result=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		List<RegistrationPojo> rList=new ArrayList<RegistrationPojo>();
		
		String password=request.getParameter("password");
		String newpass=request.getParameter("newpass");
		String repass=request.getParameter("repass");
		RequestDispatcher rd=null;
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("name");
		String pass=(String)session.getAttribute("pass");
		System.out.println(user+":"+pass);
		System.out.println(password);
		System.out.println(pass.equals(password));
		if(pass.equals(password))
		{
			if(newpass.equals(repass)) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			PreparedStatement ps=con.prepareStatement("update empregistration set password=?,repassword=? where password=? and mailid=?");
			ps.setString(1, newpass);
			ps.setString(2, repass);
			ps.setString(3, password);
			ps.setString(4, user);
			int result=ps.executeUpdate();
			if(result>0)
			{
				out.print("<html>");
				out.print("<body>");
				out.print("<h5>");
				out.print("<font color='blue'><font size='4'>");
				out.print("Password Changed Successfully</h5></font></font>");
				out.print("</body>");
				out.print("</html>");
			
			rd=request.getRequestDispatcher("PasswordChange.jsp");
			rd.include(request, response);
			}
			else
			{
				out.print("<html>");
				out.print("<body>");
				out.print("<h5>");
				out.print("<font color='blue'><font size='4'>");
				out.print("Can't Updated the Details</h5></font></font>");
				out.print("</body>");
				out.print("</html>");
				
				rd=request.getRequestDispatcher("PasswordChange.jsp");
				rd.include(request, response);
			}
			
}
catch (Exception e) {
	
	e.printStackTrace();
}   }else
{   
	out.print("<html>");
out.print("<body>");
out.print("<h5>");
out.print("<font color='blue'><font size='4'>");
out.print("NewPassword and RePassword Must be Same</h5></font></font>");
out.print("</body>");
out.print("</html>");
	rd=request.getRequestDispatcher("PasswordChange.jsp");
	rd.include(request, response);
}
		}
		else
		{
			out.print("<html>");
			out.print("<body>");
			out.print("<h5>");
			out.print("<font color='blue'><font size='4'>");
			out.print("Enter Correct Password</h5></font></font>");
			out.print("</body>");
			out.print("</html>");
			rd=request.getRequestDispatcher("PasswordChange.jsp");
			rd.include(request, response);
		}
	}

}
