package org.prasad.Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FepsLoginServlet
 */
public class FepsLoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String eid=request.getParameter("eid");
		String password=request.getParameter("password");
		
		
	    	 int status=FebsLoginForm.isValid(eid,password);
			if(status>0)
			{
				
				out.print("<html>");
				out.print("<body>");
				out.print("<font color='blue'><font size='4'>");
				out.print("WELCOME    " + eid);
				out.print("</font></font></body>");
				out.print("</html>");
				RequestDispatcher rd=request.getRequestDispatcher("HomePage1.jsp");
				rd.include(request, response);
			}
			else{
				out.print("<html>");
				out.print("<body>");
				out.print("<br><h2><center>");
				out.print("<font color='blue'><font size='5'>");
				out.print("Please check your username and Password</h2></center></font></font>");
				out.print("</body>");
				out.print("</html>");
				
				RequestDispatcher rd=request.getRequestDispatcher("FepsLogin.jsp");
				rd.include(request, response);
				}
			out.close();
			 }

}
