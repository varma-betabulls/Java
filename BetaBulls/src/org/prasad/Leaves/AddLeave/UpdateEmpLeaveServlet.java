package org.prasad.Leaves.AddLeave;

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

import org.prasad.ViewEmployee.Updateemp;

/**
 * Servlet implementation class UpdateEmpLeaveServlet
 */
public class UpdateEmpLeaveServlet extends HttpServlet {
	static int status=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String years=request.getParameter("sel1");
		String prevleave=request.getParameter("pleave");
		String sickl=request.getParameter("sick");
		String casuall=request.getParameter("casual");
		String tot=request.getParameter("tot");
		String username=request.getParameter("uname");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			PreparedStatement ps=con.prepareStatement("update empleaves set year=?,previllegedleave=?,sickleave=?,casualleave=?,total=? where ename=?");
			 
			ps.setString(1,years); 
			ps.setString(2,prevleave);
			ps.setString(3,sickl);
			ps.setString(4,casuall);
			ps.setString(5,tot);
			ps.setString(6,username);
			
			status=ps.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	   
		if(status>0){
			out.print("<html>");
			out.print("<body>");
			out.print("<h5>");
			out.print("<font color='blue'><font size='4'>");
			out.print("UPDATED SUCCESSFULLY</h5></font></font>");
			out.print("</body>");
			out.print("</html>");
				
			RequestDispatcher rd=request.getRequestDispatcher("MangLvServlet");
			rd.forward(request, response);
		}
		else{
			out.print("<html>");
			out.print("<body>");
			out.print("<h5>");
			out.print("<font color='blue'><font size='4'>");
			out.print("Sorry,Update failed. please try later</h5></font></font>");
			out.print("</body>");
			out.print("</html>");
			
			RequestDispatcher rd=request.getRequestDispatcher("MangLvServlet");
			rd.include(request, response);
		}
		
	out.close();	
	}

}
