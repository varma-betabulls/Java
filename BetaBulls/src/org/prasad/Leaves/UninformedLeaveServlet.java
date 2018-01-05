package org.prasad.Leaves;

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
 * Servlet implementation class UninformedLeaveServlet
 */
public class UninformedLeaveServlet extends HttpServlet {
	static int status=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//String uname=null,year=null;
		
		String fdate=request.getParameter("fdate");
		String eid=request.getParameter("eid");	
		String ename=request.getParameter("ename");	
		String fleave=request.getParameter("frmleaves");
		String tleave=request.getParameter("toleaves");
		String fabs=request.getParameter("frmabs");
		String tabs=request.getParameter("toabs");
		
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("name");
		
		
		
	
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			PreparedStatement ps;
			PreparedStatement ps1;
			if((fleave.equals(null) || fleave.equals("") || fleave=="") && (tleave.equals(null) || tleave.equals("") || tleave=="") && (fabs.equals(null) || fabs.equals("") || fabs=="") && (tabs.equals(null) || tabs.equals("") || tabs==""))
			{
				out.print("<html>");
				out.print("<body>");
				out.print("<h5>");
				out.print("<font color='blue'><font size='4'>");
				out.print("Please Enter Leave Dates or Absent Dates</h5></font></font>");
				out.print("</body>");
				out.print("</html>");
					
				RequestDispatcher rd=request.getRequestDispatcher("UninformedLeaves.jsp");
				rd.include(request, response);
				
			}
			else if((fabs.equals(null) || fabs.equals("") || fabs=="") && (tabs.equals(null) || tabs.equals("")||tabs==""))
					{
				ps=con.prepareStatement("insert into uninformleave(year,empid,empname,leavesfrom,leavesto)  values(?,?,?,?,?)");            
		          
	            ps.setString(1, fdate);
	            ps.setString(2, eid);
	            ps.setString(3, ename);
	            ps.setString(4, fleave);
	            ps.setString(5, tleave);
	            status=ps.executeUpdate();
					}
			else if((fleave.equals(null) || fleave.equals("") || fleave=="") && (tleave.equals(null) || tleave.equals("") || tleave==""))
					{
				ps=con.prepareStatement("insert into empabsent(year,empid,empname,absentfrom,absentto)  values(?,?,?,?,?)");            
		          
	            ps.setString(1, fdate);
	            ps.setString(2, eid);
	            ps.setString(3, ename);
	            ps.setString(4, fabs);
	            ps.setString(5, tabs);
	            status=ps.executeUpdate();
					}
			else
			{
				ps=con.prepareStatement("insert into empabsent(year,empid,empname,absentfrom,absentto)  values(?,?,?,?,?)");            
	          
	            ps.setString(1, fdate);
	            ps.setString(2, eid);
	            ps.setString(3, ename);
	            ps.setString(4,fabs);
	            ps.setString(5, tabs);
	            
	            status=ps.executeUpdate();
	            
	            ps1=con.prepareStatement("insert into uninformleave(year,empid,empname,leavesfrom,leavesto)  values(?,?,?,?,?)");            
		          
	            ps1.setString(1, fdate);
	            ps1.setString(2, eid);
	            ps1.setString(3, ename);
	            ps1.setString(4, fleave);
	            ps1.setString(5, tleave);
	            status=ps1.executeUpdate();
			}
	            
				con.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	   
		if(status>0){
			out.print("<html>");
			out.print("<body>");
			out.print("<h5>");
			out.print("<font color='blue'><font size='4'>");
			out.print("LEAVES HAVE BEEN ADDED SUCCESSFULLY</h5></font></font>");
			out.print("</body>");
			out.print("</html>");
				
			RequestDispatcher rd=request.getRequestDispatcher("UninformedLeaves.jsp");
			rd.include(request, response);
		}
		else{
			out.print("<html>");
			out.print("<body>");
			out.print("<h5>");
			out.print("<font color='blue'><font size='4'>");
			out.print("Sorry,Leaves can't be Added!, Retry</h5></font></font>");
			out.print("</body>");
			out.print("</html>");
			
			RequestDispatcher rd=request.getRequestDispatcher("UninformedLeaves.jsp");
			rd.include(request, response);
		}
		
	out.close();	
	}

}
