package org.prasad.Login;

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

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("mailid");
		String password=request.getParameter("passWord");
		
	    	 int status=LoginForm.isValid(username,password);
			if(status>0)
			{
				
				try {
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
					PreparedStatement ps=con.prepareStatement("select firstname,lastname from empregistration where mailid=?");
					
				    ps.setString(1,username);
					ResultSet rs=ps.executeQuery();
					while(rs.next()){
				String e1=rs.getString("firstname");
				String e2=rs.getString("lastname");
				String empname=e1+" "+e2;
				
				HttpSession session=request.getSession();  
		        session.setAttribute("empname",empname);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
				HttpSession session=request.getSession();  
		        session.setAttribute("name",username);
		        session.setAttribute("pass", password);
		      
				RequestDispatcher rd=request.getRequestDispatcher("HomeServlet");
				rd.include(request, response);
				
				
			}
			else{
				
				out.print("<html>");
				out.print("<body>");
				out.print("<br><h4><center>");
				out.print("<font color='blue'><font size='5'>");
				out.print("Please check your username and Password</h4></center></font></font>");
				out.print("</body>");
				out.print("</html>");
				
				RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");
				rd.include(request, response);
				}
			out.close();
			 }
	}


